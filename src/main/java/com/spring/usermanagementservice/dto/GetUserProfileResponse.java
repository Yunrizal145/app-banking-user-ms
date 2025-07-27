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
public class GetUserProfileResponse implements Serializable {
    private static final long serialVersionUID = 281587369591528746L;

    private UserProfile userProfile;
}
