package com.spring.usermanagementservice.service;

import com.spring.usermanagementservice.constant.Role;
import com.spring.usermanagementservice.constant.UserStatus;
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
import com.spring.usermanagementservice.model.UserAuthentication;
import com.spring.usermanagementservice.model.UserProfile;
import com.spring.usermanagementservice.repository.UserAuthenticationRepository;
import com.spring.usermanagementservice.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class UserManagementService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SaveDataUserRegisterResponse saveDataUserRegister(SaveDataUserRegisterRequest request){
        log.info("register start  ");
        log.info("register start req {} ", request);
        try {
            // Check data in db when is exists
            var userProfile = userProfileRepository.findTopByEmailOrPhoneNumberAndIsDeleted(request.getEmail(), request.getPhoneNumber(), false);
            log.info("check user profile : {}", userProfile);
            if (!userProfile.isEmpty()) {
                throw new RuntimeException("user is already exists!!");
            }

            log.info("start save data user : {}", request.getFullName());
            UserProfile saveUserProfile = UserProfile.builder()
                    .createdAt(new Date())
                    .updatedAt(null)
                    .fullName(request.getFullName())
                    .email(request.getEmail())
                    .phoneNumber(request.getPhoneNumber())
                    .role(Role.USER)
                    .userStatus(UserStatus.ACTIVE)
                    .isDeleted(false)
                    .failedOtpAttempts(0)
                    .failedLoginAttempts(0)
                    .lastFailedLogin(0)
                    .build();
            userProfileRepository.save(saveUserProfile);

            UserAuthentication userAuthentication = UserAuthentication.builder()
                    .createdAt(new Date())
                    .userProfile(saveUserProfile)
                    .username(request.getUsername())
                    .isRegistered(false)
                    .isDeleted(false)
                    .build();
            userAuthenticationRepository.save(userAuthentication);

            return SaveDataUserRegisterResponse.builder()
                    .fullName(request.getFullName())
                    .userStatus(UserStatus.ACTIVE)
                    .message("User Berhasil Ditambahkan")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when save data user : {}", e);
        }
    }

    public SetPasswordResponse setPasswordAndMpin(SetPasswordRequest request) {
        try {
            if (!request.getPassword().equals(request.getConfirmPassword())) {
                throw new IllegalArgumentException("Password dan Confirm Password not match");
            }

            if (!request.getMpin().equals(request.getMpinConfirm())) {
                throw new IllegalArgumentException("MPIN and Confirm MPIN not match");
            }

            UserProfile user = userProfileRepository.findTopByPhoneNumberAndIsDeleted(request.getPhoneNumber(), false)
                    .orElse(null);
            if (user==null) {
                throw new NullPointerException("Data Is Empty");
            }

            UserAuthentication userAuthentication = userAuthenticationRepository.findTopByUserProfileIdAndIsRegistered(user.getId(), false).get();

            userAuthentication.setPassword(passwordEncoder.encode(request.getPassword()));
            userAuthentication.setMpin(passwordEncoder.encode(request.getMpin()));
            userAuthentication.setRegistered(true);
            userAuthenticationRepository.save(userAuthentication);
            return SetPasswordResponse.builder()
                    .userData(user)
                    .message("Data Registered Success")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when set password and mpin : {}", e);
        }
    }



    public GetUserProfileResponse getUserProfile(GetUserProfileRequest request) {
        log.info("start get data user profile");
        try {
            Optional<UserProfile> userProfile = userProfileRepository.findTopByPhoneNumberAndIsDeleted(request.getPhoneNumber(), false);
            if (userProfile.isEmpty()) {
                throw new NullPointerException("Data User Profile is null");
            }

            return GetUserProfileResponse.builder()
                    .userProfile(userProfile.get())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when get data user profile : {}", e);
        }
    }

    public GetUserProfileResponse getUserProfileByUserProfileId(GetUserProfileRequest request) {
        log.info("start get data user profile");
        try {
            Optional<UserProfile> userProfile = userProfileRepository.findTopByIdAndIsDeleted(request.getUserProfileId(), false);
            if (userProfile.isEmpty()) {
                throw new NullPointerException("Data User Profile is null");
            }

            return GetUserProfileResponse.builder()
                    .userProfile(userProfile.get())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when get data user profile : {}", e);
        }
    }

    public GetUserAuthenticationResponse getUserAuthentication(GetUserAuthenticationRequest request) {
        log.info("start get data user authentication");
        try {
            Optional<UserAuthentication> userAuthentication = userAuthenticationRepository.findTopByUserProfileIdAndIsDeleted(request.getUserProfileId(), false);
            if (userAuthentication.isEmpty()) {
                throw new NullPointerException("Data User Authentication is null");
            }

            return GetUserAuthenticationResponse.builder()
                    .userAuthentication(userAuthentication.get())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when get data user profile : {}", e);
        }
    }

    public GetUserAuthenticationResponse getUserAuthenticationByUsername(GetUserAuthenticationRequest request) {
        log.info("start get data user authentication");
        try {
            Optional<UserAuthentication> userAuthentication = userAuthenticationRepository.findTopByUsernameAndIsDeleted(request.getUsername(), false);
            if (userAuthentication.isEmpty()) {
                throw new NullPointerException("Data User Authentication is null");
            }

            return GetUserAuthenticationResponse.builder()
                    .userAuthentication(userAuthentication.get())
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when get data user authentication : {}", e);
        }
    }

    public ValidateMpinResponse validateMpin(ValidateMpinRequest request) {
        log.info("start validate mpin");
        try {
            Optional<UserAuthentication> userAuthOpt = userAuthenticationRepository.findTopByUserProfileIdAndIsDeleted(request.getUserProfileId(), false);
            if (userAuthOpt.isEmpty()) {
                throw new NullPointerException("User Authentication is Null");
            }
            UserAuthentication userAuthentication = userAuthOpt.get();
            String mpin = userAuthentication.getMpin();
            String mpinRequest = request.getMpin();

            if (passwordEncoder.matches(mpinRequest, mpin)) {
                return ValidateMpinResponse.builder()
                        .message("Mpin Valid")
                        .build();
            }

            return ValidateMpinResponse.builder()
                    .message("Mpin Not Valid")
                    .build();
        } catch (Exception e) {
            throw new RuntimeException("Error when validate mpin on database");
        }
    }
}
