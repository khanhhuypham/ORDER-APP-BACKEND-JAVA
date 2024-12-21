package com.ra.orderapp_java.model.constant;

public enum ITEM_ON_ORDER_STATUS {
    COOKING(0), // ĐANG PHỤC VỤ
    COMPLETE(1); // YÊU CẦU THANH TOÁN

    private final int value;

    private ITEM_ON_ORDER_STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
