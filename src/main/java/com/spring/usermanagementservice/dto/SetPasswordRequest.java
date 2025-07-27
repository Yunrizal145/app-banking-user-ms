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
public class SetPasswordRequest implements Serializable {
    private static final long serialVersionUID = 4521954223419939053L;

    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String mpin;
    private String mpinConfirm;
}
