package com.spring.usermanagementservice.repository;

import com.spring.usermanagementservice.model.OtpValidation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpValidationRespository extends JpaRepository<OtpValidation, Long> {
    Optional<OtpValidation> findTopByDestinationOrderByCreatedAtDesc(String destination);
}
