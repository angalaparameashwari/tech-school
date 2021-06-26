package com.tech_school.app.enums;

public enum CommitStates {
    DRAFT(100, "draft"),
    COMMITED(200, "commited"),
    SAVED(300, "saved"),
    MERGED(400, "merged");

    public final int status;
    public final String name;
    private CommitStates(int status,String name) {
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
