package com.Unicash.UniCashIssueSystem.Repos;

import com.Unicash.UniCashIssueSystem.models.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support,Long> {
}
