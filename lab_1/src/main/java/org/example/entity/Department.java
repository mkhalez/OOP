package org.example.entity;

public class Department {
    private final int id;
    private final String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void assignTeacher(Teacher teacher) {
        System.out.println("Teacher with id:" + teacher.getId() + " works at department " + name);
    }
}
