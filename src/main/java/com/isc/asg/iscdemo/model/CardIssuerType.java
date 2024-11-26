package com.isc.asg.iscdemo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CardIssuerType {
    @EmbeddedId
    private CardIssuerTypeKey compositeKey;


    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @MapsId("cardId")
    @JoinColumn(name="card_id")
    private Card card;

}
