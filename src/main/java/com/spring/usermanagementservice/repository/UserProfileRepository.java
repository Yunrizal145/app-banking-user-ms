package com.spring.usermanagementservice.repository;

import com.spring.usermanagementservice.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findTopByEmailOrPhoneNumberAndIsDeleted(String email, String phoneNumber, boolean isDeleted);
    Optional<UserProfile> findTopByPhoneNumberAndIsDeleted(String phoneNumber, boolean isDeleted);
    Optional<UserProfile> findTopByIdAndIsDeleted(Long userProfileId, boolean isDeleted);
}
