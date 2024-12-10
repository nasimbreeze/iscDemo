package com.isc.asg.iscdemo.model;


import lombok.*;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name = "issuer")
public class Issuer{

    @Id
    @Setter
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Setter
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

    @Setter
    @Getter
    @OneToMany(mappedBy = "issuer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Card> cards = new HashSet<>();


}
