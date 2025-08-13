package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListDataUserReqeust implements Serializable {
    private static final long serialVersionUID = 229106266685873478L;

    private Role role;
}
