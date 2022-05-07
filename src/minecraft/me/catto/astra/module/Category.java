package me.catto.astra.module;

import lombok.Getter;

public enum Category {

    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER(""),
    RENDER(""),
    MISC(""),
    EXPLOIT("");

    @Getter
    private String name;

    Category(String name) {
        this.name = name;
    }

}
