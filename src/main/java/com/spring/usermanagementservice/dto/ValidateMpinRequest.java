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
public class ValidateMpinRequest implements Serializable {
    private static final long serialVersionUID = 3710898149392784410L;

    private Long userProfileId;
    private String mpin;
}
