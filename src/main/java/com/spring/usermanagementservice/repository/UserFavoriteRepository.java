package com.spring.usermanagementservice.repository;

import com.spring.usermanagementservice.model.UserFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Long> {

    List<UserFavorite> findByUserProfileIdAndBankNameIsNullAndIsDeleted(Long userProfileId, boolean isDeleted);
    List<UserFavorite> findByUserProfileIdAndBankNameIsNotNullAndIsDeleted(Long userProfileId, boolean isDeleted);
    Optional<UserFavorite> findByAccountNumberAndIsDeleted(String accountNumber, boolean isDeleted);
}
