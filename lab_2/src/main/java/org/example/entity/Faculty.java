package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private final String name;
    private final List<Department> departments = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public Teacher getTeacherById(int id) {
        return departments.stream()
                .flatMap(d -> d.getTeachers().stream())
                .filter(t -> t.getId() == id).
                findFirst().orElse(null);
    }

    public Department findDepartment(String name) {
        return departments.stream().
                filter(d -> Objects.equals(d.getName(), name))
                .findFirst().orElse(null);
    }

    public Department findDepartment(int id) {
        return departments.stream().
                filter(d -> d.getId() == id)
                .findFirst().orElse(null);
    }
}
