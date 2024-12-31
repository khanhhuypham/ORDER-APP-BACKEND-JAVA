package com.ra.orderapp_java.model.constant;

public enum ITEM_ON_ORDER_STATUS {
    WAITING_PROCESS(0),
    COOKING(1),
    COMPLETE(2),
    NOT_ENOUGH(3),
    CANCELLED(4),
    A(5),
    B(6),
    SERVICE_BLOCK_USING(7),
    SERVICE_BLOCK_STOP(8);

    private final int value;

    private ITEM_ON_ORDER_STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

