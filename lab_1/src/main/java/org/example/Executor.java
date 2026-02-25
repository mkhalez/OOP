package org.example;

import org.example.entity.*;

public class Executor {
    public void Run() {
        University university = new University(1, "BSUIR");

        Faculty faculty = new Faculty(1, "FCSN");
        university.addFaculty(faculty);

        Department department = new Department(1, "Informatics");
        faculty.addDepartment(department);

        Teacher teacher = new Teacher(1);

        faculty.addDepartment(department);
        department.assignTeacher(teacher);

        Student student = new Student(1);
        Subject subject = new Subject(1, "math");
        Grade grade = new Grade(subject, 9);
        teacher.setGradeToStudent(student, grade);

        Classroom classroom = new Classroom(1, 30);
        Schedule schedule = new Schedule(1);
        Group group = new Group(1);
        group.addStudent(student);
        schedule.makeClassBusy(classroom, subject, group);
    }
}
