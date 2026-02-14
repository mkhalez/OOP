package org.example;

import org.example.entity.*;
import java.time.LocalDateTime;

public class Executor {
    public void Run() {
        University university = new University(1, "BSUIR");

        Faculty faculty = new Faculty(1, "FCSN");
        university.addFaculty(faculty);

        Department department = new Department(1, "Informatics");
        faculty.addDepartment(department);

        Group group = new Group(1);
        Student student = new Student(1);
        department.addStudent(student);
        group.addStudent(student);
        student.setGroupId(group);

        Teacher teacher = new Teacher(1);
        department.addTeacher(teacher);
        Subject firstSubject = new Subject(1, "math");
        department.addSubject(firstSubject);
        teacher.assignToSubject(firstSubject);
        student.enrollToSubject(firstSubject);
        teacher.assignGrade(student, firstSubject, 9);

        Subject secondSubject = new Subject(2, "oop");
        department.addSubject(secondSubject);
        teacher.assignToSubject(secondSubject);
        student.enrollToSubject(secondSubject);
        teacher.assignGrade(student, secondSubject, 7);

        System.out.println("Average grade: " + student.calculateAverageGrade());

        Classroom classroom = new Classroom(1, 30);
        Schedule schedule = new Schedule(1, firstSubject, teacher, group, classroom, LocalDateTime.now());
        System.out.println(schedule);

    }
}
