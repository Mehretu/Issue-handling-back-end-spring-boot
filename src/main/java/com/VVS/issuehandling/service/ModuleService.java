package com.VVS.issuehandling.service;


import com.VVS.issuehandling.convertors.ModuleConvertor;
import com.VVS.issuehandling.dto.request.ModuleIn;
import com.VVS.issuehandling.dto.response.ModuleOut;
import com.VVS.issuehandling.exception.NotFondException;
import com.VVS.issuehandling.repo.ModuleRepository;
import com.VVS.issuehandling.model.Module;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    public ModuleOut create(ModuleIn moduleIn)  {
        Module module1 = new Module();
        module1.setId(null);
        module1.setName(moduleIn.getName());
        return ModuleConvertor.toModuleOut(moduleRepository.save(module1));
//        return null;
    }
    public ModuleOut update(ModuleIn moduleIn) {
        Module  moduleExisting = moduleRepository.findById(moduleIn.getId()).orElseThrow(()-> new NotFondException(Module.class, moduleIn.getId()));
            Module module1 = new Module();
            module1.setId(moduleIn.getId());
            module1.setName(moduleIn.getName());
            return ModuleConvertor.toModuleOut(moduleRepository.save(module1));

    }

    public void delete(Long moduleId) {
        Module  module1 = moduleRepository.findById(moduleId).orElseThrow(()-> new NotFondException(Module.class, moduleId));
        moduleRepository.deleteById(moduleId);

    }

    public List<ModuleOut> list(int page, int pagesize) {
        Pageable pageable = PageRequest.of(page, pagesize);
        return ModuleConvertor.toModuleOutList(moduleRepository.findAll(pageable).getContent());
    }

    public ModuleOut findById(Long moduleId) {
        return ModuleConvertor.toModuleOut(moduleRepository.findById(moduleId).orElseThrow(()-> new NotFondException(Module.class, moduleId)));
    }

}
