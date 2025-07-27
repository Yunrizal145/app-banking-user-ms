package com.spring.usermanagementservice.repository;

import com.spring.usermanagementservice.model.UserAuthentication;
import com.spring.usermanagementservice.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findTopByUserProfileAndIsRegistered(UserProfile userProfile, boolean isRegistered);
    Optional<UserAuthentication> findTopByUserProfileIdAndIsDeleted(Long userProfileId, boolean isDeleted);
}
