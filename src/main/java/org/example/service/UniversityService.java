package org.example.service;

import org.example.dto.FacultyAndDepartment;
import org.example.dto.FacultyAndDepartmentNames;
import org.example.entities.*;

import java.util.List;
import java.util.Objects;

public class UniversityService {
    private University university;

    public void createUniversity(String name) {
        university = new University(name);
    }

    public void createFaculty(String name) {
        Faculty faculty = new Faculty(name);
        university.addFaculty(faculty);
    }

    public void createDepartment(String departmentName, String facultyName) {
        Department department = new Department(departmentName);

        Faculty faculty = findFaculty(facultyName);
        if(faculty == null) return;

        faculty.addDepartment(department);
    }

    public void createTeacher(String id, String firstName,
                              String lastName, String employeeNumber,
                              FacultyAndDepartmentNames facultyAndDepartmentNames) {
        Teacher teacher = new Teacher(id, firstName, lastName, employeeNumber);
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        facultyAndDepartment.department().addTeacher(teacher);
    }

    public void createCourse(String courseName, String courseCode,
                             FacultyAndDepartmentNames facultyAndDepartmentNames,
                             String employeeNumber) {
        Course course = new Course(courseName, courseCode);

        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        Teacher teacher = facultyAndDepartment.department().getTeachers().stream()
                .filter(t -> t.getEmployeeNumber().equals(employeeNumber))
                .findFirst().orElse(null);

        if(teacher == null) return;

        facultyAndDepartment.department().addCourse(course);
        teacher.assignToCourse(course);
    }

    void createStudent(String id, String firstName, String lastName,
                       String studentNumber, String facultyName, String departmentName,
                       String groupName) {
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(
                new FacultyAndDepartmentNames(facultyName, departmentName));

        if(facultyAndDepartment == null) return;

        Student student = new Student(id, firstName, lastName,
                studentNumber, facultyAndDepartment, new Group(groupName));

        facultyAndDepartment.department().addStudent(student);
    }

    void enrollStudent(String studentNumber, String courseCode) {
        Student student = findStudentByNumber(studentNumber);
        Course course = findCourseByCode(courseCode);
        if(student == null || course == null) return;

        student.enrollToCourse(course);
    }

    private Student findStudentByNumber(String studentNumber) {
        return university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getStudents().stream())
                .filter(s -> Objects.equals(s.getStudentNumber(), studentNumber))
                .findFirst().orElse(null);
    }

    private Course findCourseByCode(String courseCode) {
        return university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getCourses().stream())
                .filter(c -> Objects.equals(c.getCode(), courseCode))
                .findFirst().orElse(null);
    }

    private FacultyAndDepartment findFacultyAndDepartment(FacultyAndDepartmentNames facultyAndDepartment) {
        Faculty faculty = university.findFacultyByName(facultyAndDepartment.facultyName());
        if(faculty == null) return null;

        Department department = faculty.findDepartmentByName(facultyAndDepartment.departmentName());
        if(department == null) return null;

        return new FacultyAndDepartment(faculty, department);
    }

    private Faculty findFaculty(String facultyName) {
        return university.findFacultyByName(facultyName);
    }
}
