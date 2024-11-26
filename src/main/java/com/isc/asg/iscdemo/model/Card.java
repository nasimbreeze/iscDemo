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
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Getter
    @Setter
    @Column(name = "activated")
    private boolean activated = false;

    @Setter
    @Getter
    @Size(message = "card number must be 16 digits", min = 16, max = 16)
    @Column(name = "card_no")
    private int cardNo;

    @Getter
    @Setter
    private int issuerCode;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "card_type")
    private CardType cardType;

    @Getter
    @Setter
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date expiraryDate;

    @Setter
    @Getter
    @Column(insertable = false, updatable = false)
    private Long issuerId;

    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Issuer issuer;


}