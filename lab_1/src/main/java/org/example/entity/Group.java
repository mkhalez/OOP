package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int id;

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addStudent(Student student) {
        System.out.println("Student " + student.getId() + " added to group " + id);
    }

}
