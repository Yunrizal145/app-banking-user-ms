package com.spring.usermanagementservice.controller;

import com.spring.usermanagementservice.dto.GetUserAuthenticationRequest;
import com.spring.usermanagementservice.dto.GetUserAuthenticationResponse;
import com.spring.usermanagementservice.dto.GetUserProfileRequest;
import com.spring.usermanagementservice.dto.GetUserProfileResponse;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterRequest;
import com.spring.usermanagementservice.dto.SaveDataUserRegisterResponse;
import com.spring.usermanagementservice.dto.SetPasswordRequest;
import com.spring.usermanagementservice.dto.SetPasswordResponse;
import com.spring.usermanagementservice.dto.ValidateMpinRequest;
import com.spring.usermanagementservice.dto.ValidateMpinResponse;
import com.spring.usermanagementservice.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementServiceController {

    @Autowired
    private UserManagementService userManagementService;

    @PostMapping("/saveuserregistration")
    public SaveDataUserRegisterResponse saveDataUserRegister(@RequestBody SaveDataUserRegisterRequest request){
        return userManagementService.saveDataUserRegister(request);
    }

    @PostMapping("/setpasswordandmpin")
    public SetPasswordResponse setPasswordAndMpin(@RequestBody SetPasswordRequest request) {
        return userManagementService.setPasswordAndMpin(request);
    }

    @PostMapping("/getuserprofile")
    public GetUserProfileResponse getUserProfile(@RequestBody GetUserProfileRequest request) {
        return userManagementService.getUserProfile(request);
    }

    @PostMapping("/getuserprofilebyid")
    public GetUserProfileResponse getUserProfileById(@RequestBody GetUserProfileRequest request) {
        return userManagementService.getUserProfileByUserProfileId(request);
    }

    @PostMapping("/getuserauthentication")
    public GetUserAuthenticationResponse getUserAuthentication(@RequestBody GetUserAuthenticationRequest request) {
        return userManagementService.getUserAuthentication(request);
    }

    @PostMapping("/getuserauthenticationbyusername")
    public GetUserAuthenticationResponse getUserAuthenticationByUsername(@RequestBody GetUserAuthenticationRequest request) {
        return userManagementService.getUserAuthenticationByUsername(request);
    }

    @PostMapping("/validatempinbyencryption")
    public ValidateMpinResponse validateMpin(@RequestBody ValidateMpinRequest request) {
        return userManagementService.validateMpin(request);
    }
}
