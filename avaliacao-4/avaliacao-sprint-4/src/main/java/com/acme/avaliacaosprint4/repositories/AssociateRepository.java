package com.acme.avaliacaosprint4.repositories;


import com.acme.avaliacaosprint4.entities.AssociateEntity;
import com.acme.avaliacaosprint4.enums.PoliticalOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateEntity, Long> {

    Optional<List<AssociateEntity>> findByPoliticalOffice(PoliticalOffice politicalOffice);
}
