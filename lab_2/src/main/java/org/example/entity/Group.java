package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private final int id;
    private final List<Student> students = new ArrayList<>();

    public Group(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudentIds() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                '}';
    }
}
