package com.VVS.issuehandling.controller;

import com.VVS.issuehandling.dto.request.DeveloperIn;
import com.VVS.issuehandling.dto.response.DeveloperOut;
import com.VVS.issuehandling.security.Util;
import com.VVS.issuehandling.security.other.UserInfo;
import com.VVS.issuehandling.security.other.UserInfoUserDetailsService;
import com.VVS.issuehandling.service.DeveloperService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developer")
@SecurityRequirement(name = "Bearer Authentication")
@PreAuthorize("hasAnyAuthority('DEVELOPER', 'ADMIN')")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;
    private final UserInfoUserDetailsService userInfoService;

//    public DeveloperController(DeveloperService developerService, UserInfoUserDetailsService userInfoService) {
//        this.developerService = developerService;
//        this.userInfoService = userInfoService;
//    }

    @PostMapping("/create")
    public DeveloperOut create(DeveloperIn dev) {
        userInfoService.saveUser(new UserInfo(null,dev.getUserName(),dev.getPhone(),dev.getEmail(),dev.getPassword(), Util.getRole(dev.getRole())));
        return developerService.create(dev);
    }

    @PutMapping("/update")
    public DeveloperOut update(DeveloperIn developerIn) {
        return developerService.update(developerIn);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("developerId") Long developerId)  {
        developerService.delete(developerId);
    }

    @GetMapping("/list")
    public List<DeveloperOut> list (@Nullable @RequestParam("start") Integer start,
                                    @Nullable @RequestParam("max") Integer max) {
        return developerService.list(start,max);
    }

    @GetMapping("/findById")
    public DeveloperOut findById(@RequestParam("developerId") Long developerId) {
        return developerService.findById(developerId);
    }

    @GetMapping("listByModuleId")
    public List<DeveloperOut> listByModuleId(@RequestParam("parameter") Long moduleId,
                                             @Nullable @RequestParam("start") Integer start,
                                             @Nullable @RequestParam("max") Integer max) {
        return developerService.listByModuleId(moduleId, start, max);
    }

}
