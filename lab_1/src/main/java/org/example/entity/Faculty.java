package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final int id;
    private final String name;
    private final List<Integer> departmentIds = new ArrayList<>();

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
        departmentIds.add(department.getId());
    }

    public void removeDepartment(int departmentId) {
        departmentIds.remove(departmentId);
    }

    public List<Integer> getDepartmentIds() {
        return departmentIds;
    }
}
