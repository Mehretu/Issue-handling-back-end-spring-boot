package com.Unicash.UniCashIssueSystem.Repos;

import com.Unicash.UniCashIssueSystem.models.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType,Long> {
}
