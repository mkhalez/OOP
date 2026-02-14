package org.example.entity;

import java.util.Objects;

public class UniversityService {
    private University university;

    public void createUniversity(int id, String name) {
        university = new University(id, name);
    }

    public void createFaculty(String name) {
        Faculty faculty = new Faculty(name);
        university.addFaculty(faculty);
    }

    public void createDepartment(int departmentId, String departmentName, String facultyName) {
        Department department = new Department(departmentId, departmentName);

        Faculty faculty = findFaculty(facultyName);
        if(faculty == null) return;

        faculty.addDepartment(department);
    }



    public void createTeacher(int id, String firstName,
                              String lastName,
                              FacultyAndDepartmentNames facultyAndDepartmentNames) {
        Teacher teacher = new Teacher(firstName, lastName, id);
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        facultyAndDepartment.department().addTeacher(teacher);
    }

    public void createSubject(int id, String description,
                             FacultyAndDepartmentNames facultyAndDepartmentNames,
                             int teacherId) {
        Subject subject = new Subject(id, description);

        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        Teacher teacher = facultyAndDepartment.department().getTeachers().stream()
                .filter(t -> t.getId() == teacherId)
                .findFirst().orElse(null);

        if(teacher == null) return;

        facultyAndDepartment.department().addSubject(subject);
        teacher.assignToSubject(subject);
    }

    public void createStudent(int id, String firstName, String lastName,
                              FacultyAndDepartmentNames facultyAndDepartmentNames,
                              int groupId) {
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        Student student = new Student(firstName, lastName, id, new Group(groupId));

        facultyAndDepartment.department().addStudent(student);
    }

    public void enrollStudent(int studentId, int subjectId) {
        Student student = findStudentById(studentId);
        Subject subject = findSubjectById(subjectId);
        if(student == null || subject == null) return;

        student.enrollToSubject(subject);
        subject.addStudent(student);
    }

    public void assignGrade(int teacherId, int studentId, int subjectId, int grade) {
        Student student = findStudentById(studentId);
        Subject subject = findSubjectById(subjectId);
        Teacher teacher = findTeacherById(teacherId);

        if(subject.getTeacher() != teacher || !student.getSubjectAssessment().containsKey(subject)) return;

        if(student == null || subject == null || teacher == null) return;

        teacher.assignGrade(student, subject, grade);
    }

    public double calculateAverageGrade(int studentId) {
        Student student = findStudentById(studentId);

        if(student == null) throw new IllegalArgumentException("student is not found");

        return student.calculateAverageGrade();
    }

    private Teacher findTeacherById(int id) {
        return university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getTeachers().stream())
                .filter(t -> t.getId() == id)
                .findFirst().orElse(null);
    }

    private Student findStudentById(int id) {
        return university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getStudents().stream())
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    private Subject findSubjectById(int id) {
        return university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getSubjects().stream())
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    private Faculty findFaculty(String facultyName) {
        return university.findFacultyByName(facultyName);
    }

    private FacultyAndDepartment findFacultyAndDepartment(FacultyAndDepartmentNames facultyAndDepartment) {
        Faculty faculty = university.findFacultyByName(facultyAndDepartment.facultyName());
        if(faculty == null) return null;

        Department department = faculty.findDepartmentByName(facultyAndDepartment.departmentName());
        if(department == null) return null;

        return new FacultyAndDepartment(faculty, department);
    }


}
