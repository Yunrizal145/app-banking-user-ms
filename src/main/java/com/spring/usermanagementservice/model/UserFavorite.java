package com.spring.usermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_favorite", schema = "user_management_service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFavorite implements Serializable {
    private static final long serialVersionUID = -3374355442965814015L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_profile_id")
    private Long userProfileId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "favorite_name")
    private String favoriteName;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "is_deleted")
    private Boolean isDeleted;
}
