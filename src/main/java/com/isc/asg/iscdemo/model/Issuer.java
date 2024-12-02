package com.isc.asg.iscdemo.model;


import lombok.*;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "issuer")
public class Issuer{

    @Id
    @Getter
    @NotNull
    @Digits(integer = 6, fraction = 0)
    @Size(message = "issuer code must be 6 digits", min = 6, max = 6)
    @Column(name = "issuer_code", length = 6)
    private String issuerCode;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private String issuerName;

    @OneToMany( mappedBy = "issuer", cascade = CascadeType.PERSIST)
    private Set<CardDetails> cardDetailsSet;


    @OneToMany(mappedBy = "issuer")
    private Collection<Card> card;

    public Collection<Card> getCard() {
        return card;
    }

    public void setCard(Collection<Card> card) {
        this.card = card;
    }
}
