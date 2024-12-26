package com.ra.orderapp_java.model.constant;


public enum ORDER_TYPE {
    DINE_IN(0), // ĐANG PHỤC VỤ
    TAKE_AWAY(1),
    DELIVERY(2),
    BUFFET(3),
    CATERING(4),
    FOOD_COURT(5); // YÊU CẦU THANH TOÁN

    private final int value;

    private ORDER_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}