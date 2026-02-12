package org.example.service;

import org.example.entities.*;

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

        Faculty faculty = university.findFacultyByName(facultyName);
        if(faculty == null) return;

        faculty.addDepartment(department);
    }

    public void createTeacher(String id, String firstName,
                              String lastName, String employeeNumber,
                              String facultyName, String departmentName) {
        Teacher teacher = new Teacher(id, firstName, lastName, employeeNumber);
        Faculty faculty = university.findFacultyByName(facultyName);
        if(faculty == null) return;

        Department department = faculty.findDepartmentByName(departmentName);
        if(department == null) return;

        department.addTeacher(teacher);

    }
}
