package com.isc.asg.iscdemo.model;

public enum CardType {
        CR("CREDIT"),
        DE("DEBIT");

    public final String label;

     CardType(String label) {
        this.label = label;
    }

}
