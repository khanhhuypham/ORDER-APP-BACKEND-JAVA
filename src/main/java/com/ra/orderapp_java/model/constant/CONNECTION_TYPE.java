package com.ra.orderapp_java.model.constant;


public enum CONNECTION_TYPE {
    WIFI(0),
    IMIN(1),
    SUNMI(2),
    USB(3),
    BLUETOOTH(4);

    private final int value;

    private CONNECTION_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


}



