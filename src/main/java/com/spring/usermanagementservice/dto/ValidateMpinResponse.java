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
public class ValidateMpinResponse implements Serializable {
    private static final long serialVersionUID = -7836090746783090103L;

    private String message;
}
