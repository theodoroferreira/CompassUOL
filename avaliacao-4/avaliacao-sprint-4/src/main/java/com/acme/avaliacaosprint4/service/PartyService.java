package com.acme.avaliacaosprint4.service;

import com.acme.avaliacaosprint4.dto.request.PartyRequestDto;
import com.acme.avaliacaosprint4.dto.response.PartyResponseDto;
import com.acme.avaliacaosprint4.enums.Ideology;
import java.util.List;

public interface PartyService {

    PartyResponseDto create(PartyRequestDto request);

    List<PartyResponseDto> listAll(Ideology ideology);

    PartyResponseDto list(Long id);

    PartyResponseDto update(Long id, PartyRequestDto request);

    void delete(Long id);
}