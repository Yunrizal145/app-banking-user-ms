package com.spring.usermanagementservice.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public class OtpGenerator {

    @Value("${number.otp.random}")
    private static String numberOtp;

    public static String generateOtp(int length) {
        String numbers = numberOtp;
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return otp.toString();
    }
}
