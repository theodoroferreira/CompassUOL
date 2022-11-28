package com.acme.avaliacaosprint4.service;
import com.acme.avaliacaosprint4.dto.request.PartyRequestDto;
import com.acme.avaliacaosprint4.dto.response.PartyResponseDto;
import com.acme.avaliacaosprint4.entities.PartyEntity;
import com.acme.avaliacaosprint4.enums.Ideology;
import com.acme.avaliacaosprint4.repositories.PartyRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartyServiceImpl implements PartyService{

    private final PartyRepository partyRepository;

    private final ModelMapper modelMapper;

    @Override
    public PartyResponseDto create(PartyRequestDto request) {
        PartyEntity party = modelMapper.map(request, PartyEntity.class);
        PartyEntity createdParty = partyRepository.save(party);
        return modelMapper.map(createdParty, PartyResponseDto.class);
    }

    @Override
    public List<PartyResponseDto> listAll(Ideology ideology) {
        if (ideology != null) {
            Optional<List<PartyEntity>> optional = partyRepository.findByIdeology(ideology);
            return optional.get().stream().map(ps -> modelMapper.map(ps, PartyResponseDto.class)).collect(Collectors.toList());
        } else {
            List<PartyEntity> parties = partyRepository.findAll();
            return parties.stream().map(ps -> modelMapper.map(ps, PartyResponseDto.class)).collect(Collectors.toList());
        }
    }

    @Override
    public PartyResponseDto list(Long id){
        Optional<PartyEntity> optional = partyRepository.findById(id);
        return modelMapper.map(optional.get(), PartyResponseDto.class);
    }

    @Override
    public PartyResponseDto update(Long id, PartyRequestDto request){
        Optional<PartyEntity> optional = partyRepository.findById(id);
        PartyEntity party = optional.get();
        party.setIdeology(request.getIdeology());
        party.setFoundationDate(request.getFoundationDate());
        party.setPartyName(request.getPartyName());
        party.setAbbreviation(request.getAbbreviation());
        return modelMapper.map(party, PartyResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        if (partyRepository.existsById(id)) {
            partyRepository.deleteById(id);
        }
    }
}
