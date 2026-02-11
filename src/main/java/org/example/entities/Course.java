package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private String name;
    private String code;
    private Teacher teacher;
    private List<Enrollment> enrollments = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void addEnrollment(Enrollment enrollment) {
        if(enrollments.contains(enrollment)) return;
        enrollments.add(enrollment);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }


}
