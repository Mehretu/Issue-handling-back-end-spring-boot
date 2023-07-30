package com.Unicash.UniCashIssueSystem.Repos;

import com.Unicash.UniCashIssueSystem.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
}
