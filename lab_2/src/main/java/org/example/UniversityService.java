package org.example;

import org.example.entity.*;
import org.example.interfaces.Service;
import java.time.LocalDateTime;
import java.util.function.Function;

public class UniversityService implements Service {
    private University university;

    public void createUniversity(int id, String name) {
        university = new University(id, name);
    }

    @Override
    public void createFaculty(String name) {
        Faculty faculty = new Faculty(name);
        university.addFaculty(faculty);
    }

    @Override
    public void createDepartment(int departmentId, String departmentName, String facultyName) {
        Department department = new Department(departmentId, departmentName);

        Faculty faculty = findFaculty(facultyName);
        if(faculty == null) return;

        faculty.addDepartment(department);
    }

    @Override
    public void createTeacher(int id, String firstName,
                              String lastName,
                              FacultyAndDepartmentNames facultyAndDepartmentNames) {
        Teacher teacher = new Teacher(firstName, lastName, id);
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        facultyAndDepartment.department().addTeacher(teacher);
    }

    @Override
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

    @Override
    public void createStudent(int id, String firstName, String lastName,
                              FacultyAndDepartmentNames facultyAndDepartmentNames,
                              int groupId) {
        FacultyAndDepartment facultyAndDepartment = findFacultyAndDepartment(facultyAndDepartmentNames);

        if(facultyAndDepartment == null) return;

        Student student = new Student(firstName, lastName, id, new Group(groupId));

        facultyAndDepartment.department().addStudent(student);
    }

    @Override
    public void enrollStudent(int studentId, int subjectId) {
        Student student = findStudentById(studentId);
        Subject subject = findSubjectById(subjectId);
        if(student == null || subject == null) return;

        student.enrollToSubject(subject);
        subject.addStudent(student);
    }

    @Override
    public void assignGrade(int teacherId, int studentId, int subjectId, int grade) {
        Student student = findStudentById(studentId);
        Subject subject = findSubjectById(subjectId);
        Teacher teacher = findTeacherById(teacherId);

        if(subject.getTeacher() != teacher || !student.getSubjectAssessment().containsKey(subject)) return;

        if(student == null || subject == null || teacher == null) return;

        teacher.assignGrade(student, subject, grade);
    }

    @Override
    public <T extends Number> T calculateAverageGrade(
            int studentId,
            Function<Double, T> converter) {
        Student student = findStudentById(studentId);

        if(student == null) throw new IllegalArgumentException("student is not found");

        double average = student.calculateAverageGrade();

        return converter.apply(average);
    }

    @Override
    public void createSchedule(int id, int subjectId, int teacherId,
                               int groupId, int classId, int classCapacity) {
        Subject subject = findSubjectById(subjectId);
        Teacher teacher = findTeacherById(teacherId);
        Group group = findGroupById(groupId);
        Classroom classroom = new Classroom(classId, classCapacity);
        
        if(subject == null || teacher == null || group == null) return;
        
        Schedule schedule = new Schedule(id, subject, teacher, group, classroom, LocalDateTime.now());
        university.addSchedule(schedule);
    }

    @Override
    public void displaySchedules() {
        for(var schedule : university.getSchedules()) {
            System.out.println(schedule);
        }
    }
    
    private Group findGroupById(int id) {
        Student student =  university.getFaculties().stream()
                .flatMap(f -> f.getDepartments().stream())
                .flatMap(d -> d.getStudents().stream())
                .filter(s -> s.getGroup().getId() == id)
                .findFirst().orElse(null);
        if(student == null) return null;
        return student.getGroup();
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

        Department department = faculty.findDepartment(facultyAndDepartment.departmentName());
        if(department == null) return null;

        return new FacultyAndDepartment(faculty, department);
    }


}
