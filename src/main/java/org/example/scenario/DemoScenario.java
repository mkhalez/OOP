package org.example.scenario;

import org.example.entities.*;

public class DemoScenario {
    public void run() {
        University university = new University("BSUIR");

        Faculty faculty = new Faculty("FCSaN");

        Department department = new Department("Informatics");

        faculty.addDepartment(department);

        Teacher teacher = new Teacher("HB34567", "Alexander", "Ivanov", "teacher_52873");
        department.addTeacher(teacher);

        Course course = new Course("OOP", "s902");
        department.addCourse(course);
        teacher.assignToCourse(course);

        Group group = new Group("453503");

        Student student = new Student("HB38382", "Alexander", "Mikhalko", "student_2373238");
        department.addStudent(student);



    }
}
