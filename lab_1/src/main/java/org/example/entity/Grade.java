package org.example.entity;

public class Grade {
    private final int id;
    private final int value;
    private final String subjectDescription;

    public Grade(Subject subject, int value) {
        this.id = subject.getId();
        this.value = value;
        this.subjectDescription = subject.getDescription();
    }

    public int getCourseId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }
}
