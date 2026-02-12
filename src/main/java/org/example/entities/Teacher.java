package org.example.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person{
    private final String employeeNumber;
    private Department department;
    private final List<Course> courses = new ArrayList<>();

    public Teacher(String id, String firstName, String lastName, String employeeNumber) {
        super(id, firstName, lastName);
        this.employeeNumber = employeeNumber;
    }

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(employeeNumber, teacher.employeeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeNumber);
    }


}
