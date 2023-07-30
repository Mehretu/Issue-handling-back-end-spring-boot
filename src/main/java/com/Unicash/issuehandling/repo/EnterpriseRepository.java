package com.Unicash.UniCashIssueSystem.Repos;

import com.Unicash.UniCashIssueSystem.models.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
}
