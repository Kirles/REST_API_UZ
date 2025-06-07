package org.example.model;

public enum WagonClass {
    К("Купе"),
    П("Плацкарт"),
    Л("Люкс");

    private final String description;

    WagonClass(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
