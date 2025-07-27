package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.constant.TypeOtp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtpRequest implements Serializable {
    private static final long serialVersionUID = 673157362890518039L;

    @NonNull
    private TypeOtp sendOtpType;
    private String phoneNumber;
    private String email;
}
