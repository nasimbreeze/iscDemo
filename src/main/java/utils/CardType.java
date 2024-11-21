package utils;

import utils.CardType;

public enum CardType {
        CREDIT("CREDIT"), DEBIT("DEBIT");

    public final String label;

    private CardType(String cardType) {
        this.label = cardType;
    }

    public CardType toCardType() {
        switch (this) {
            case CREDIT:
                return CardType.CREDIT;
            case DEBIT:
                return CardType.CREDIT;
            default:
                throw new IllegalStateException("Type not supported");
        }
    }
}
