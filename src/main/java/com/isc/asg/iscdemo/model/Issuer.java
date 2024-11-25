package com.isc.asg.iscdemo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "issuer")
public class Issuer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Digits(integer = 6, fraction = 0)
    @Setter
    @Column(nullable = false, unique = true)
    @Getter
    @NotNull
    @Size(message = "issuer code must be 6 digits", min = 6, max = 6)
    private int issuerCode;

    @Setter
    @Getter
    @NotNull
    @Column(nullable = false)
    private int issuerName;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany( mappedBy = "issuer", cascade = CascadeType.PERSIST)
    private List<Card> cards;

    public Issuer() {

    }
}
