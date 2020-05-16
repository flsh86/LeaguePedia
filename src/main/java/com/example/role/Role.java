package com.example.role;

public enum Role {
    TEST(-1),
    TOP(0),
    JUNGLE(1),
    MID(2),
    BOT(3),
    SUPPORT(4),
    EMPTY(5);

    private final int roleID;

    Role(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return this.roleID;
    }
}
