package com.VVS.issuehandling.repo;
import com.VVS.issuehandling.model.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module,Long> {
    List<Module> findAll();
    Page<Module> findAll(Pageable pageable);
}
