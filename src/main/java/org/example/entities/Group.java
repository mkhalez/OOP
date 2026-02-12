package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if(student == null || students.contains(student)) return;

        students.add(student);
        student.setGroup(this);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
