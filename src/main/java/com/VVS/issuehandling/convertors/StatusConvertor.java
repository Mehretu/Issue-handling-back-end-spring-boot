package com.VVS.issuehandling.convertors;

import com.VVS.issuehandling.dto.response.StatusOut;
import com.VVS.issuehandling.model.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusConvertor {

    public static StatusOut toStatusOut(Status status) {
        StatusOut statusOut = new StatusOut();
        statusOut.setId(status.getId());
        statusOut.setName(status.getName());

        return statusOut;
    }

    public static List<StatusOut> toStatusOutList(List<Status> statuses) {
        List<StatusOut> statusOutList = new ArrayList<>();
        statuses.stream().forEach(status -> {
            statusOutList.add(toStatusOut(status));
        });
        return statusOutList;
    }
}
