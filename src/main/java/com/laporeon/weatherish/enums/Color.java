package com.laporeon.weatherish.enums;

public enum Color {
    BOLD("\u001B[1m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    ITALIC("\u001B[3m"),
    RESET("\u001B[0m");

    private final String ansiCode;

    Color(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return ansiCode;
    }
}
