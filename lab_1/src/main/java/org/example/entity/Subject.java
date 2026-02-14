package org.example.entity;

public class Subject {
    private int id;
    private String description;
    private int teacherId;

    public Subject(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public void setName(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
