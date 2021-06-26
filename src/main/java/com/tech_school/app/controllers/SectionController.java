package com.tech_school.app.controllers;

import com.tech_school.app.api_models.sections.CreateSectionApiModel;
import com.tech_school.app.api_models.sections.SectionApiModel;
import com.tech_school.app.mapper.SectionMapper;
import com.tech_school.app.services.sections.SectionService;
import com.tech_school.core.exceptions.GeneralException;
import com.tech_school.core.security.RequestDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.Callable;

@RestController
public class SectionController implements SectionApi {
    private SectionService service;
    private SectionMapper mapper;

    @Autowired
    public SectionController(SectionService service, SectionMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Callable<ResponseEntity<SectionApiModel>> create(@Valid CreateSectionApiModel body) {
        return () -> {
            RequestDetails.setCurrentUser(body.getAuthorId());
            SectionApiModel sectionApiModel = service.create(mapper.createSectionToSectionCommit(body))
                    .map(courseCommit -> mapper.sectionCommitToSectionApiModel(courseCommit))
                    .orElseThrow(() -> new GeneralException("Un expected error"));
            return ResponseEntity.status(HttpStatus.CREATED).body(sectionApiModel);
        };
    }
}
