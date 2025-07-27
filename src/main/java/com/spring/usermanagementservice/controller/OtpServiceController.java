package com.spring.usermanagementservice.controller;

import com.spring.usermanagementservice.dto.OtpRequest;
import com.spring.usermanagementservice.dto.OtpValidationRequest;
import com.spring.usermanagementservice.dto.OtpValidationResponse;
import com.spring.usermanagementservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class OtpServiceController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/otp-send")
    public void sendOtp(@Validated @RequestBody OtpRequest otpRequest) throws IOException {
        otpService.sendOtp(otpRequest);
    }

    @PostMapping("/otp-verification")
    public OtpValidationResponse validateOtp(@RequestBody OtpValidationRequest request) {
        boolean valid = otpService.validateOtp(request.getDestination(), request.getOtpCode());
        if (valid) {
            return OtpValidationResponse.builder()
                    .message("OTP Valid")
                    .isSuccess(true)
                    .build();
        } else {
            return OtpValidationResponse.builder()
                    .message("OTP Tidak Valid")
                    .isSuccess(false)
                    .build();
        }
    }
}
