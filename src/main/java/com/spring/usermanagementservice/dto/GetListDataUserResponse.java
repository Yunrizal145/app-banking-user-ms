package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListDataUserResponse implements Serializable {
    private static final long serialVersionUID = -609552881321232744L;

    private List<UserProfile> userProfileList;
}
