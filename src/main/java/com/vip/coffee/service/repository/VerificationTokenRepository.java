package com.vip.coffee.service.repository;

import com.vip.coffee.service.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken getFirstByToken(String token);
}
