package com.spring.usermanagementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OtpValidationResponse implements Serializable {
    private static final long serialVersionUID = -8696120561311287399L;

    private String message;
    private boolean isSuccess;
}
