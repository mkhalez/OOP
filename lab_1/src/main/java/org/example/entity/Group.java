package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final int id;
    private final List<Integer> studentIds = new ArrayList<>();

    public Group(int id) {
        this.id = id;
    }

    public void addStudent(Student student) {
        studentIds.add(student.getGroupId());
    }

    public void removeStudent(Student student) {
        studentIds.remove(student.getId());
    }

    public int getId() {
        return id;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }
}
