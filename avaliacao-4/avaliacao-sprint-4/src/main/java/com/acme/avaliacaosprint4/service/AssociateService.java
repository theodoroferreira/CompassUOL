package com.acme.avaliacaosprint4.service;

import com.acme.avaliacaosprint4.dto.request.AssociateRequestDto;
import com.acme.avaliacaosprint4.dto.response.AssociateResponseDto;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;

import java.util.List;

public interface AssociateService {

    AssociateResponseDto create(AssociateRequestDto request);

    List<AssociateResponseDto> listAll(PoliticalOffice politicalOffice);

    AssociateResponseDto list(Long id);


    AssociateResponseDto update(Long id, AssociateRequestDto request);

    void delete(Long id);
}
