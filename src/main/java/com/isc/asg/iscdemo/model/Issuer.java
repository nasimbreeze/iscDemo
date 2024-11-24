package com.isc.asg.iscdemo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "issuer")
@AllArgsConstructor
@NoArgsConstructor
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
    private int issuerName;

    @NotNull
    private Long cardId;

    private Long userId;
}
