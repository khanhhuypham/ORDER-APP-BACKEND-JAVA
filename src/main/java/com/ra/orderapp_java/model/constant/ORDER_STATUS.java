package com.ra.orderapp_java.model.constant;

public enum ORDER_STATUS {
    OPEN(0), // ĐANG PHỤC VỤ
    PAYMENT_REQUEST(1), // YÊU CẦU THANH TOÁN
    COMPLETE(2), //HOÀN TẤT
    WAITING_MERGED(3), //
    WAITING_COMPLETE(4), // CHỜ THU TIỀN
    CANCEL(5); // ĐÃ HỦY

    private final int value;

    private ORDER_STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}
