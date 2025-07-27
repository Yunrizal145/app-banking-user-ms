package com.spring.usermanagementservice.dto;

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
public class OtpValidationRequest implements Serializable {
    private static final long serialVersionUID = 8263871052558463235L;

    @NonNull
    private String destination;

    @NonNull
    private String otpCode;
}
