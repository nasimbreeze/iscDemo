package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"customer_id", "issuer_id", "cardType"})
})
@NamedQueries({
        @NamedQuery(name = "Card.findAll", query = "select c from Card c")
})
public class Card {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Getter
    @Setter
    @Column(name = "activated", nullable = false)
    private boolean activated = false;

    @Setter
    @Getter
    @Min(value = 18, message = "card number must be 16 digits")
    @Size(message = "card number must be 16 digits", min = 16, max = 16)
    @Column(nullable = false, length = 16, unique = true)
    private String cardNo;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private CardType cardType;

    @Getter
    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "MM yy")
    private Date expiryDate;


    @ManyToOne
    @JoinColumn(name = "issuer_id")
    @Setter
    @Getter
    private Issuer issuer;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Setter
    @Getter
    private Customer customer;


}