package com.spring.usermanagementservice.service;

import com.spring.usermanagementservice.constant.TypeOtp;
import com.spring.usermanagementservice.dto.OtpRequest;
import com.spring.usermanagementservice.model.OtpValidation;
import com.spring.usermanagementservice.repository.OtpValidationRespository;
import com.spring.usermanagementservice.util.OtpGenerator;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class OtpService {

//    @Value("${}")
    private String apiUrl;

//    @Value("${}")
    private String apiKey;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private OtpValidationRespository otpValidationRespository;

    public void sendOtp(OtpRequest request) throws IOException {
        String otp = OtpGenerator.generateOtp(6);
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MINUTE, 5);
        Date expired = calendar.getTime();

        String destination = request.getSendOtpType().equals(TypeOtp.EMAIL) ?
                request.getEmail() : request.getPhoneNumber();

        OtpValidation otpValidation = new OtpValidation();
        otpValidation.setDestination(destination);
        otpValidation.setOtp(otp);
        otpValidation.setCreatedAt(now);
        otpValidation.setExpiresAt(expired);
        otpValidationRespository.save(otpValidation);

        if (TypeOtp.EMAIL.equals(request.getSendOtpType())) {
            sendEmail(destination, otp);
        } else {
            sendOtpToWhatsApp(request.getPhoneNumber(), otp);
        }
    }

    public boolean validateOtp(String phoneNumber, String inputOtp) {
        Optional<OtpValidation> latestOtp = otpValidationRespository.findTopByDestinationOrderByCreatedAtDesc(phoneNumber);

        if (latestOtp.isPresent()) {
            OtpValidation otp = latestOtp.get();
            return otp.getOtp().equals(inputOtp) && new Date().before(otp.getExpiresAt());
        }

        return false;
    }

    private void sendEmail(String to, String otp) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("OTP Anda");
        msg.setText("Kode OTP Anda adalah: " + otp);
        javaMailSender.send(msg);
    }

    public void sendOtpToWhatsApp(String phoneNumber, String otpCode) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String message = "Kode OTP Anda: " + otpCode;

        String json = "{"
                + "\"phone\":\"" + phoneNumber + "\","
                + "\"message\":\"" + message + "\","
                + "\"secret\":false,"
                + "\"priority\":true"
                + "}";

        RequestBody body = RequestBody.create(json, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(apiUrl)
                .post(body)
                .addHeader("Authorization", apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Gagal kirim pesan ke WhatsApp: " + response.body().string());
            }
        }
    }
}
