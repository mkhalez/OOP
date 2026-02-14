package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final int id;
    private final String name;
    private final List<Integer> teacherIds = new ArrayList<>();
    private final List<Integer> studentIds = new ArrayList<>();
    private final List<Integer> subjectIds = new ArrayList<>();

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        teacherIds.add(teacher.getId());
    }

    public void removeTeacher(Teacher teacher) {
        teacherIds.remove(teacher.getId());
    }

    public void addStudent(Student student) {
        studentIds.add(student.getId());
    }

    public void removeStudent(Student student) {
        studentIds.remove(student.getId());
    }

    public void addSubject(Subject subject) {
        subjectIds.add(subject.getId());
    }

    public void removeSubject(Subject subject) {
        subjectIds.remove(subject.getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getTeacherIds() {
        return teacherIds;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }

    public List<Integer> getSubjectIds() {
        return subjectIds;
    }
}
