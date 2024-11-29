package com.isc.asg.iscdemo.model;


import lombok.*;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "issuer")
public class Issuer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issuerId;

    @Setter
    @Column(name = "issuer_code", nullable = false, unique = true, length = 6)
    @Getter
    @NotNull
    @Digits(integer = 6, fraction = 0)
    @Size(message = "issuer code must be 6 digits", min = 6, max = 6)
    private int issuerCode;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private String issuerName;

    @OneToMany( mappedBy = "issuer", cascade = CascadeType.PERSIST)
    private Set<CardDetails> cardDetailsSet;


}
