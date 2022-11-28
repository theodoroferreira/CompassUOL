package com.acme.avaliacaosprint4.repositories;

import com.acme.avaliacaosprint4.entities.PartyEntity;
import com.acme.avaliacaosprint4.enums.Ideology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<PartyEntity, Long> {
    Optional<List<PartyEntity>> findByIdeology(Ideology ideology);
}