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

    public void removeTeacher(int teacherId) {
        teacherIds.remove(teacherId);
    }

    public void addStudent(Student student) {
        studentIds.add(student.getId());
    }

    public void removeStudent(int studentId) {
        studentIds.remove(studentId);
    }

    public void addSubject(Subject subject) {
        subjectIds.add(subject.getId());
    }

    public void removeSubject(int subjectId) {
        subjectIds.remove(subjectId);
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
