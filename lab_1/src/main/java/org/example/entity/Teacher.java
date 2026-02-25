package org.example.entity;

public class Teacher {
    private final int id;

    public Teacher(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setGradeToStudent(Student student, Grade grade) {
        System.out.println("Student " + student.getId() + " get " + grade.getValue() + " on " + grade.getSubjectDescription());
        student.addGrade(grade);
    }

    public void teach(Subject subject) {
        System.out.println("Teacher " + id + " teaches " + subject.getDescription());
    }
}
