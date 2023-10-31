package com.VVS.issuehandling.convertors;

import com.VVS.issuehandling.dto.response.IssueTypeOut;
import com.VVS.issuehandling.model.IssueType;

import java.util.ArrayList;
import java.util.List;

public class IssueTypeConvertor {

    public static IssueTypeOut toIssueTypeOut(IssueType issueType) {
        IssueTypeOut issueTypeOut = new IssueTypeOut();
        issueTypeOut.setId(issueType.getId());
        issueTypeOut.setName(issueType.getName());
        return issueTypeOut;
    }

    public static List<IssueTypeOut> toIssueTypeOutList(List<IssueType> issueTypes) {
        List<IssueTypeOut> issueTypeOutList = new ArrayList<>();
        issueTypes.stream().forEach(issueType -> {
            issueTypeOutList.add(toIssueTypeOut(issueType));
        });
        return issueTypeOutList;
    }
}
