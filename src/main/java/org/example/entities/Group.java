package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students = new ArrayList<>();

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
}
