package com.Unicash.UniCashIssueSystem.Repos;

import com.Unicash.UniCashIssueSystem.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
}
