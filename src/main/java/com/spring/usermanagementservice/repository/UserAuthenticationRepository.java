package com.spring.usermanagementservice.repository;

import com.spring.usermanagementservice.model.UserAuthentication;
import com.spring.usermanagementservice.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findTopByUserProfileIdAndIsRegistered(Long userProfileId, boolean isRegistered);
    Optional<UserAuthentication> findTopByUserProfileIdAndIsDeleted(Long userProfileId, boolean isDeleted);
    Optional<UserAuthentication> findTopByUsernameAndIsDeleted(String username, boolean isDeleted);
}
