package org.example.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String employeeNumber;
    private Department department;
    private List<Course> courses = new ArrayList<>();

    public void assignToCourse(Course course) {
        if(courses.contains(course)) return;

        courses.add(course);
        course.setTeacher(this);
    }

    public void assignGrade(Student student, Course course, int value) {
        Enrollment enrollment = student.findEnrollmentByCourse(course);
        if(enrollment == null) return;

        enrollment.setGrade(new Grade(value, LocalDateTime.now()));
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
