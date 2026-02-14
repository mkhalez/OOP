package org.example.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person{
    private final int id;
    private final List<Subject> subjects = new ArrayList<>();

    public Teacher(String firstName, String secondName, int id) {
        super(firstName, secondName);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void assignToSubject(Subject subject) {
        subjects.add(subject);
        subject.setTeacher(this);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void assignGrade(Student student, Subject subject, int value) {
        student.assignGrade(new Grade(subject, value));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                '}';
    }
}
