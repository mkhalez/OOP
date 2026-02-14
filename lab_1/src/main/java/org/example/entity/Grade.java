package org.example.entity;

public class Grade {
    private final int id;
    private final int value;

    public Grade(int subjectId, int value) {
        this.id = subjectId;
        this.value = value;
    }

    public int getCourseId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
