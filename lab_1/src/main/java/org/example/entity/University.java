package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final int id;
    private final String name;

    public University(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addFaculty(Faculty faculty) {
        System.out.println("Faculty " + faculty.getName() + " added to university " + name);
    }
}
