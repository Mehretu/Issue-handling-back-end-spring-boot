package com.VVS.issuehandling.controller;

import com.VVS.issuehandling.dto.request.EnterpriseIn;
import com.VVS.issuehandling.dto.response.EnterpriseOut;
import com.VVS.issuehandling.service.EnterpriseService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/enterprise")
@SecurityRequirement(name = "Bearer Authentication")
@PreAuthorize("hasAuthority('ADMIN')")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/create")
    public EnterpriseOut create(EnterpriseIn enterpriseIn) {
        return enterpriseService.create(enterpriseIn);
    }

    @PutMapping("/update")
    public EnterpriseOut update(EnterpriseIn enterpriseIn) {
        return enterpriseService.update(enterpriseIn);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("enterpriseId") Long enterpriseId)  {
       enterpriseService.delete(enterpriseId);
    }

    @GetMapping("/list")
    public List<EnterpriseOut> list (@RequestParam("page") Integer page,
                                     @RequestParam("pageSize") Integer pageSize) {
        return enterpriseService.list(page, pageSize);
    }

    @GetMapping("/findById")
    public EnterpriseOut findById(@RequestParam("enterpriseId") Long enterpriseId) {
        return enterpriseService.findById(enterpriseId);
    }

    @GetMapping("listByModuleId")
    public List<EnterpriseOut> listByModuleId(@RequestParam("parameter") Long moduleId,
                                              @RequestParam("page") Integer page,
                                              @RequestParam("pageSize") Integer pageSize) {
        return enterpriseService.listByModuleId(moduleId, page, pageSize);
    }
    @GetMapping("listBySupportId")
    public List<EnterpriseOut> listBySupportId(@RequestParam("parameter") Long supportId,
                                               @RequestParam("page") Integer page,
                                               @RequestParam("pageSize") Integer pageSize) {
        return enterpriseService.listBySupportId(supportId, page, pageSize);
    }
    ///////////////////////////////////
    @PutMapping("assignSupports")
    public void assignSupports(@RequestParam("enterpriseId") Long enterpriseId,
                                                  @RequestParam("supportIds") List<Long> supportIds) {
        enterpriseService.assignSupports(enterpriseId, supportIds);
    }

    @PutMapping("/cancelSupports")
    public void cancelSupports(@RequestParam("enterpriseId") Long enterpriseId,
                                                  @RequestParam("supportIds") Set<Long> supportIds) {
        enterpriseService.cancelSupports(enterpriseId, supportIds);
    }

}
