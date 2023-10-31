package com.VVS.issuehandling.convertors;

import com.VVS.issuehandling.dto.response.SupportOut;
import com.VVS.issuehandling.model.Enterprise;
import com.VVS.issuehandling.model.Support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SupportConvertor {

    public static SupportOut toSupportOut(Support support) {
        SupportOut supportOut = new SupportOut();
        supportOut.setId(support.getId());
        supportOut.setUsername(support.getUsername());
        supportOut.setFirstName(support.getFirstName());
        supportOut.setLastName(support.getLastName());
        supportOut.setEnterprises(
                support.getEnterprises().stream()
                        .map(Enterprise::getName)
                        .collect(Collectors.toList()));

        return supportOut;
    }

    public static List<SupportOut> toSupportOutList(List<Support> supports) {
        List<SupportOut> supportOutList = new ArrayList<>();
        supports.forEach(support -> {
            supportOutList.add(toSupportOut(support));
        });
        return supportOutList;
    }

}
