package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetPasswordResponse implements Serializable {
    private static final long serialVersionUID = -4148750719964141093L;

    private String message;
    private UserProfile userData;
}
