package com.acme.avaliacaosprint4.service;

import com.acme.avaliacaosprint4.dto.request.AssociateRequestDto;
import com.acme.avaliacaosprint4.dto.response.AssociateResponseDto;
import com.acme.avaliacaosprint4.entities.AssociateEntity;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;
import com.acme.avaliacaosprint4.repositories.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssociateServiceImpl implements AssociateService {

    private final AssociateRepository associateRepository;

    private final ModelMapper modelMapper;

    @Override
    public AssociateResponseDto create(AssociateRequestDto request) {
        AssociateEntity associate = modelMapper.map(request, AssociateEntity.class);
        AssociateEntity createdAssociate = associateRepository.save(associate);
        return modelMapper.map(createdAssociate, AssociateResponseDto.class);
    }

    @Override
    public List<AssociateResponseDto> listAll(PoliticalOffice politicalOffice) {
        if (politicalOffice != null) {
            Optional<List<AssociateEntity>> optional = associateRepository.findByPoliticalOffice(politicalOffice);
            return optional.get().stream().map(ps -> modelMapper.map(ps, AssociateResponseDto.class)).collect(Collectors.toList());
        } else {
            List<AssociateEntity> associates = associateRepository.findAll();
            return associates.stream().map(ps -> modelMapper.map(ps, AssociateResponseDto.class)).collect(Collectors.toList());
        }
    }

    @Override
    public AssociateResponseDto list(Long id) {
        Optional<AssociateEntity> optional = associateRepository.findById(id);
        return modelMapper.map(optional.get(), AssociateResponseDto.class);
    }

    @Override
    public AssociateResponseDto update(Long id, AssociateRequestDto request) {
        Optional<AssociateEntity> optional = associateRepository.findById(id);
        AssociateEntity associate = optional.get();
        associate.setPoliticianName(request.getPoliticianName());
        associate.setPoliticalOffice(request.getPoliticalOffice());
        associate.setDateOfBirth(request.getDateOfBirth());
        associate.setGender(request.getGender());
        return modelMapper.map(associate, AssociateResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        if (associateRepository.existsById(id)) {
            associateRepository.deleteById(id);
        }
    }
}
