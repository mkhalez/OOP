package org.example.interfaces;

import org.example.entity.FacultyAndDepartmentNames;

import java.util.function.Function;

public interface Service {
    void createUniversity(int id, String name);

    void createFaculty(String name);

    void createDepartment(int departmentId, String departmentName, String facultyName);

    void createTeacher(int id, String firstName,
                       String lastName,
                       FacultyAndDepartmentNames facultyAndDepartmentNames);

    void createSubject(int id, String description,
                       FacultyAndDepartmentNames facultyAndDepartmentNames,
                       int teacherId);

    void createStudent(int id, String firstName, String lastName,
                       FacultyAndDepartmentNames facultyAndDepartmentNames,
                       int groupId);

    void enrollStudent(int studentId, int subjectId);

    void assignGrade(int teacherId, int studentId, int subjectId, int grade);

    <T extends Number> T calculateAverageGrade(
            int studentId,
            Function<Double, T> converter);

    void createSchedule(int id, int subjectId, int teacherId,
                        int groupId, int classId, int classCapacity);

    void displaySchedules();
}
