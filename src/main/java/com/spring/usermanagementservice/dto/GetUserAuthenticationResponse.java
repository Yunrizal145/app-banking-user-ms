package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.model.UserAuthentication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserAuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -6202793829506181189L;

    private UserAuthentication userAuthentication;
}
