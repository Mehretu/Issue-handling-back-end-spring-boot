package com.VVS.issuehandling.service;


import com.VVS.issuehandling.convertors.StatusConvertor;
import com.VVS.issuehandling.dto.request.StatusIn;
import com.VVS.issuehandling.dto.response.StatusOut;
import com.VVS.issuehandling.exception.NotFondException;
import com.VVS.issuehandling.model.Status;
import com.VVS.issuehandling.repo.StatusRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    public StatusOut create(StatusIn statusIn)  {
        Status status1 = new Status();
//        status1.setId(null);
        status1.setName(statusIn.getName());
        status1.setDescription(statusIn.getDescription());
        return StatusConvertor.toStatusOut(statusRepository.save(status1));

    }
    public StatusOut update(StatusIn statusIn) {
        Status statusExisting = statusRepository.findById(statusIn.getId()).orElseThrow(()-> new NotFondException(Status.class, statusIn.getId()));
            Status status1 = new Status();
            status1.setId(statusIn.getId());
            status1.setName(statusIn.getName());
            status1.setDescription(statusIn.getDescription());
            return StatusConvertor.toStatusOut(statusRepository.save(status1));

    }

    public void delete(Long statusId) {
        statusRepository.findById(statusId).orElseThrow(()-> new NotFondException(Status.class, statusId));
        statusRepository.deleteById(statusId);

    }

    public List<StatusOut> list(int page, int pagesize) {
        Pageable pageable = PageRequest.of(page, pagesize);
        return StatusConvertor.toStatusOutList(statusRepository.findAll(pageable).getContent());
    }

    public int listCount() {
        return statusRepository.findAll().size();
    }


    public StatusOut findById(Long statusId) {
        return StatusConvertor.toStatusOut(statusRepository.findById(statusId).orElseThrow(() -> new NotFondException(Status.class, statusId)));
    }
}


