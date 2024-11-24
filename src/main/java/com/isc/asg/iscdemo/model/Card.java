package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import utils.CardType;

import java.util.Date;

@Data
@Entity
@Table(name = "cards")
public class Card {


    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private boolean activated = false;

    @Setter
    @Getter
    @Size(message = "card number must be 16 digits", min = 16, max = 16)
    private int cardNo;

    @Getter
    @Setter
    private int issuerCode;

    @Getter
    @Setter
    private CardType cardType;

    @Getter
    @Setter
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date expiraryDate;



}