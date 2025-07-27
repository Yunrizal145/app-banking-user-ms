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
public class GetUserProfileRequest implements Serializable {
    private static final long serialVersionUID = 408777002171491742L;

    private String phoneNumber;
    private String email;
}
