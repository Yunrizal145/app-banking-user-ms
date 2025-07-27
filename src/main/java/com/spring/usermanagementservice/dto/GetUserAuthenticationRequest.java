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
public class GetUserAuthenticationRequest implements Serializable {
    private static final long serialVersionUID = -2400994935472312558L;

    private Long userProfileId;
}
