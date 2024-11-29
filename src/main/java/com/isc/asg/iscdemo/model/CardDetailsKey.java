package com.isc.asg.iscdemo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class CardDetailsKey implements Serializable {

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "issuer_code")
    private int issuerCode;

    public CardDetailsKey() {}

  /*  public CardIssuerTypeKey(String cardType, int issuerCode) {
        this.cardType = cardType;
        this.issuerCode = issuerCode;
    }*/

    // equals() and hashCode()
}

