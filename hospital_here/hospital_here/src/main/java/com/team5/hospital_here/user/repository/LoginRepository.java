package com.team5.hospital_here.user.repository;

import com.team5.hospital_here.user.entity.login.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String email);
    Login findByVerified(String verified);
}
