package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private final int id;
    private final List<Integer> subjectIds = new ArrayList<>();

    public Teacher(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getSubjectId() {
        return subjectIds;
    }

    public void assignToSubject(Subject subject) {
        subjectIds.add(subject.getId());
    }

    public void assignGrade(Student student, Subject subject, int value) {
        student.assignGrade(new Grade(subject.getId(), value));
    }
}
