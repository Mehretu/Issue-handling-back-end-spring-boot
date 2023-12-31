package com.VVS.issuehandling.convertors;

import com.VVS.issuehandling.dto.response.ModuleOut;
import com.VVS.issuehandling.model.Module;

import java.util.ArrayList;
import java.util.List;

public class ModuleConvertor {

    public static ModuleOut toModuleOut(Module module) {
        ModuleOut moduleOut = new ModuleOut();
        moduleOut.setId(module.getId());
        moduleOut.setName(module.getName());

        return moduleOut;
    }

    public static List<ModuleOut> toModuleOutList(List<Module> modules) {
        List<ModuleOut> moduleOutList = new ArrayList<>();
        modules.stream().forEach(module -> {
            moduleOutList.add(toModuleOut(module));
        });
        return moduleOutList;
    }
}
