package com.isc.asg.iscdemo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Setter
    @Getter
    @NotNull
    private int issuerCode;

    @Setter
    @Getter
    @NotNull
    private int issuerName;

    @NotNull
    private Long cardId;

    private Long userId;
}
