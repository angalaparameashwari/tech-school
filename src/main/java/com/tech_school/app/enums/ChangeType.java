package com.tech_school.app.enums;

public enum ChangeType {

    ADDED(100, "added"),
    UPDATED(200, "updated"),
    REMOVED(300, "removed"),
    ORDER_CHANGED(400, "order_changed");

    public final int status;
    public final String name;
    private ChangeType(int status,String name) {
        this.status = status;
        this.name = name;
    }

    public static int i(String text) {
        for (CommitStates b : CommitStates.values()) {
            if (String.valueOf(b.name).equals(text)) {
                return b.status;
            }
        }
        return 0;
    }

    public static String name(int level) {
        for (CommitStates b : CommitStates.values()) {
            if (level == b.status) {
                return b.name;
            }
        }
        return null;
    }
}
