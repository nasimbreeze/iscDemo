package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "card")
@NamedQueries({
        @NamedQuery(name = "Card.findAll", query = "select c from Card c")
})
public class Card {

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "activated")
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

    @Column(insertable = false, updatable = false)
    private Long issuerId;


    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Issuer issuer;


}