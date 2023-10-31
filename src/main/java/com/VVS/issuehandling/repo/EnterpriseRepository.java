package com.VVS.issuehandling.repo;

import com.VVS.issuehandling.model.Enterprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
    List<Enterprise> findAll();
    Page<Enterprise> findAll(Pageable pageable);
    List<Enterprise> findByModuleId(Long moduleId);
    Page<Enterprise> findByModuleId(Long moduleId, Pageable pageable);

//    List<Enterprise> findBySupport(List<Support> supports);//but we'll send 1 support.
}
