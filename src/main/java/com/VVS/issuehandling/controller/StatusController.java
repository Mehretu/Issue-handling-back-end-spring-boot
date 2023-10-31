package com.VVS.issuehandling.controller;

import com.VVS.issuehandling.dto.request.StatusIn;
import com.VVS.issuehandling.dto.response.StatusOut;
import com.VVS.issuehandling.service.StatusService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
@SecurityRequirement(name = "Bearer Authentication")
//@PreAuthorize("hasAuthority('ADMIN')")
//@IsAdmin
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping("/create")
    public StatusOut create(StatusIn statusIn) {
        return statusService.create(statusIn);
    }

    @PostMapping("/update")
    public StatusOut update(StatusIn statusIn) {
        return statusService.update(statusIn);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("statusId") Long statusId)  {
        statusService.delete(statusId);
    }

    @GetMapping("/list")
    public List<StatusOut> list(@RequestParam("page") int page,
                                @RequestParam("pageSize") int pageSize) {
            return statusService.list(page, pageSize);
        }

    @PutMapping("/findById")
    public StatusOut findById(@RequestParam("statusId") Long statusId) {
        return statusService.findById(statusId);
    }

}
