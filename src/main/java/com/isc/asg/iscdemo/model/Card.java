package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "card")
@NamedQueries({
        @NamedQuery(name = "Card.findAll", query = "select c from Card c")
})
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @Getter
    @Setter
    @Column(name = "activated")
    private boolean activated = false;

    @Setter
    @Getter
    @Size(message = "card number must be 16 digits", min = 16, max = 16)
    @Column(nullable = false, length = 16)
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
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "card")
    private Set<CardDetails> cardDetails;

}