package com.app.project.userservice.repository;

import com.app.project.userservice.model.entity.Otp;
import com.app.project.userservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {
    Optional<Otp> findByUser(User user);
}
