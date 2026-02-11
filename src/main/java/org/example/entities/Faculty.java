package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private List<Department> departments = new ArrayList<>();

    public Faculty(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void addDepartments(Department department) {
        if(departments.contains(department)) return;
        departments.add(department);
    }

    public void removeDepartments(Department department) {
        departments.remove(department);
    }

    public Department findDepartmentByName(String name) {
        return departments.stream().filter(department -> department.getName()
                .equals(name)).findFirst().orElse(null);
    }
}
