package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "cards")
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean activated = false;

    private Integer cardNo;

    private String issuerCode;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    private  String cardType = "";


    public void setId(Long id) {
        this.id = id;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public void setIssuerCode(String issuerCode) {
        this.issuerCode = issuerCode;
    }


}