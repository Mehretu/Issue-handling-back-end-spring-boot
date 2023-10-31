package com.VVS.issuehandling.repo;

import com.VVS.issuehandling.model.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer,Long> {
    List<Developer> findByModuleId(Long moduleId);
    Page<Developer> findByModuleId(Long moduleId, Pageable pageable);
}
