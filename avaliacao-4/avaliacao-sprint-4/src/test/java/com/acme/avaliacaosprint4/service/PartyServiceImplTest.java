package com.acme.avaliacaosprint4.service;

import com.acme.avaliacaosprint4.dto.request.PartyRequestDto;
import com.acme.avaliacaosprint4.dto.response.PartyResponseDto;
import com.acme.avaliacaosprint4.entities.PartyEntity;
import com.acme.avaliacaosprint4.repositories.PartyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PartyServiceImplTest {

    public static final Long id = 1l;

    @InjectMocks
    private PartyServiceImpl partyService;

    @Mock
    private PartyRepository partyRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    void shouldCreateParty() {
        var party = new PartyEntity();
        var response = new PartyResponseDto();
        var request = new PartyRequestDto();

        Mockito.when(modelMapper.map(any(), eq(PartyEntity.class))).thenReturn(party);
        Mockito.when(partyRepository.save(any())).thenReturn(party);
        Mockito.when(modelMapper.map(any(), eq(PartyResponseDto.class))).thenReturn(response);

        PartyResponseDto partyResponseDto = partyService.create(request);

        assertEquals(response, partyResponseDto);
        verify(partyRepository).save(any());
    }

    @Test
    void shouldlistAllParties() {
    }

    @Test
    void shouldListOnePartById() {
        var party = new PartyEntity();
        var response = new PartyResponseDto();

        Mockito.when(partyRepository.findById(any())).thenReturn(Optional.of(party));
        Mockito.when(modelMapper.map(any(), eq(PartyResponseDto.class))).thenReturn(response);

        PartyResponseDto partyResponseDto = partyService.list(id);

        assertEquals(response, partyResponseDto);

    }

    @Test
    void shouldUpdateParty() {
    }

    @Test
    void shouldDeleteParty() {
    }

}