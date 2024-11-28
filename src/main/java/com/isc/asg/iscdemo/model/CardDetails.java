package com.isc.asg.iscdemo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class CardDetails {

    @EmbeddedId
    private cardDetailsKey cardDetailsId;

    @ManyToOne
    @MapsId("card_type")
    @JoinColumn(name = "card_type")
    private Card card;

    @ManyToOne
    @MapsId("issuer_code")
    @JoinColumn(name = "issuer_code")
    private Issuer issuer;

}
