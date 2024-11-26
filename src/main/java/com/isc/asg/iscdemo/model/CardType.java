package com.isc.asg.iscdemo.model;

public enum CardType {
        CREDIT("CREDIT"), DEBIT("DEBIT");

    public final String label;

    private CardType(String cardType) {
        this.label = cardType;
    }

    public CardType toCardType() {
        return switch (this) {
            case CREDIT -> CardType.CREDIT;
            case DEBIT -> CardType.DEBIT;
            default -> throw new IllegalStateException("Type not supported");
        };
    }
}
