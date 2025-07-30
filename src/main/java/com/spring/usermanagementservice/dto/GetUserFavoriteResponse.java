package com.spring.usermanagementservice.dto;

import com.spring.usermanagementservice.model.UserFavorite;
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
public class GetUserFavoriteResponse implements Serializable {
    private static final long serialVersionUID = -4188926816521107566L;

    private List<UserFavorite> userFavoriteList;
}
