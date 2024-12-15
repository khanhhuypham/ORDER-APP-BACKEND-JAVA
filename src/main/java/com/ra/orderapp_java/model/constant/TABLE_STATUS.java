package com.ra.orderapp_java.model.constant;




public enum TABLE_STATUS {
    CLOSE(0),
    BOOKING(1),
    USING(2),
    MERGED(3);

    private final int value;

    private TABLE_STATUS(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}



