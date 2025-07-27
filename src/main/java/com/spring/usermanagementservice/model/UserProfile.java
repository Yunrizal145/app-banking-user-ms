package com.spring.usermanagementservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.usermanagementservice.constant.Role;
import com.spring.usermanagementservice.constant.UserStatus;
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
@Table(name = "user_profile", schema = "user_management_service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile implements Serializable {
    private static final long serialVersionUID = 557365543019910957L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "alias_name")
    private String aliasName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private Role role;

    @Column(name = "user_status")
    private UserStatus userStatus;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;

    @Column(name = "failed_otp_attempts")
    private int failedOtpAttempts;

    @Column(name = "last_failed_login")
    private int lastFailedLogin;


}
