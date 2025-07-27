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
public class SaveDataUserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 5256267379078734438L;

    private String fullName;
    private String username;
    private String email;
    private String phoneNumber;
    private UserStatus userStatus;
}
