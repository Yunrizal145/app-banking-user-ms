package com.spring.usermanagementservice.controller;

import com.spring.usermanagementservice.dto.OtpRequest;
import com.spring.usermanagementservice.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class OtpServiceController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/otp-send")
    public void sendOtp(@Validated @RequestBody OtpRequest otpRequest) throws IOException {
        otpService.sendOtp(otpRequest);
    }
}
