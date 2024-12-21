package com.ra.orderapp_java.model.constant;

public enum CATEGORY_TYPE {
    EXTRA_CHARGE(0),
    FOOD(1),
    DRINK(2),
    OTHER(3),
    SEAFOOD(4),
    SERVICE(5),
    BUFFET_TICKET(6);

    private final int value;

    private CATEGORY_TYPE(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CATEGORY_TYPE fromValue(Integer value) {
        for (CATEGORY_TYPE status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid category type value: " + value);
    }

}
