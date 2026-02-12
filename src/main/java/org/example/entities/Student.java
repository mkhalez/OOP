package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person{
    private final String studentNumber;
    private Department department;
    private Group group;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Student(String id, String firstName, String lastName, String studentNumber) {
        super(id, firstName, lastName);
        this.studentNumber = studentNumber;
    }

    public void enrollToCourse(Course course) {
        Enrollment enrollment = new Enrollment(this, course);
        if(enrollments.contains(enrollment)) return;

        enrollments.add(enrollment);
        course.addEnrollment(enrollment);
    }

    public double calculateAverageGrade() {
        double sum = 0;
        int count = 0;

        for(var e : enrollments) {
            if(e.getGrade() != null) {
                sum += e.getGrade().getValue();
                count++;
            }
        }

        if(count == 0) return 0;

        return sum / count;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public Enrollment findEnrollmentByCourse(Course course) {
        Enrollment enrollment = new Enrollment(this, course);
        return enrollments.stream().filter(e ->
                e.equals(enrollment)).findFirst().orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(studentNumber, student.studentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentNumber);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
