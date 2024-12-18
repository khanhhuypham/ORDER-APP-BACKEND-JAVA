package com.ra.orderapp_java.model.constant;

public enum CATEGORY_TYPE {
    PROCESSED(1),
    NON_PROCESSED(2),
    OTHER(3);

    private final int value;

    private CATEGORY_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
