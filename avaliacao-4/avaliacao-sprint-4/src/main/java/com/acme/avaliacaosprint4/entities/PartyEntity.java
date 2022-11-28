package com.acme.avaliacaosprint4.entities;

import com.acme.avaliacaosprint4.enums.Ideology;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PARTIES")
public class PartyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false)
    private Long id;

    @Column(name="PARTY_NAME")
    private String partyName;

    @Column(name="ABBREVIATION")
    private String abbreviation;

    @Enumerated(EnumType.STRING)
    @Column(name="IDEOLOGY")
    private Ideology ideology;

    @Column(name="FOUNDATION_DATE")
    private LocalDate foundationDate;

}
