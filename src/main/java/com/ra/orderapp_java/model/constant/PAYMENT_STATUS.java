package com.ra.orderapp_java.model.constant;

public enum PAYMENT_STATUS {
    UNCOMPLETE(0),
    COMPLETE(1);

    private final int value;

    private PAYMENT_STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

