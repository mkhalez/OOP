package org.example.entity;

public class Student {
    private final int id;
    private int generalRating = 0;

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addGrade(Grade grade) {
        generalRating += grade.getValue();
    }

    public int getGeneralRating() {
        return generalRating;
    }

    public void setGeneralRating(int generalRating) {
        this.generalRating = generalRating;
    }
}
