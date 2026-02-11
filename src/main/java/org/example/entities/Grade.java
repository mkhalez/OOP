package org.example.entities;

import java.time.LocalDateTime;

public class Grade {
    private final int value;
    private final LocalDateTime date;

    public Grade(int value, LocalDateTime date) {
        if(value < 1 || value > 10) throw new IllegalArgumentException("invalid value");
        this.value = value;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getValue() {
        return value;
    }
}
