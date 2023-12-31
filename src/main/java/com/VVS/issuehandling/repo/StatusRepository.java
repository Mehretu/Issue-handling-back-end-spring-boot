package com.VVS.issuehandling.repo;
import com.VVS.issuehandling.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    List<Status> findAll();
    Page<Status> findAll(Pageable pageable);
}
