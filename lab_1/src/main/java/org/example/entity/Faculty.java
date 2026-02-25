package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final int id;
    private final String name;

    public Faculty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addDepartment(Department department) {
        System.out.println("Department " + department.getName() + " added to faculty " + name);
    }
}
