package com.ra.orderapp_java.model.constant;

public enum PRINTER_TYPE {
    DRINK_AND_GOODS(0),
    FOOD(1),
    CASHIER(2),
    FISHBOWL(3),
    STAMP(4),
    SCANGLE(5),
    APP_FOOD_CASHIER(6),
    APP_FOOD_STAMP(7);

    private final int value;

    private PRINTER_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        switch (this) {
            case DRINK_AND_GOODS:
                return "Kho bia/quầy bar/hàng hóa";
            case FOOD:
                return "Bếp nấu";
            case CASHIER:
                return "Thu Ngân";
            case FISHBOWL:
                return "Hồ cá";
            case STAMP:
                return "Stamp";
            case SCANGLE:
                return "SCANGLE";
            case APP_FOOD_CASHIER:
                return "Hoá đơn app food";
            case APP_FOOD_STAMP:
                return "Stamp app food";
            default:
                return "Bếp nấu";
        }
    }
}



