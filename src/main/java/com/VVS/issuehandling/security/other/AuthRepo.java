package com.VVS.issuehandling.security.other;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends  JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String username);
}
