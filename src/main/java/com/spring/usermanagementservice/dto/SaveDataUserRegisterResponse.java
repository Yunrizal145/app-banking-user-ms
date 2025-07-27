package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.constant.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveDataUserRegisterResponse implements Serializable {
    private static final long serialVersionUID = 5260154880652476387L;

    private String fullName;
    private UserStatus userStatus;
    private String message;
}
