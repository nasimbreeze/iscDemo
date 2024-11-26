package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import lombok.Setter;

@Table(name = "card_type")
public enum CardType {
        CREDIT("CREDIT"), DEBIT("DEBIT");

    @Column(name = "card_type")
        public  String label;

    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long card_type_id;

    private CardType(String cardType) {
        this.label = cardType;
    }

    CardType() {

    }

    public CardType toCardType() {
        return switch (this) {
            case CREDIT -> CardType.CREDIT;
            case DEBIT -> CardType.DEBIT;
            default -> throw new IllegalStateException("Type not supported");
        };
    }

}
