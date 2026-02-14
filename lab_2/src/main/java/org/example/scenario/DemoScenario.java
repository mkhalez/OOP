package org.example.scenario;

import org.example.entity.FacultyAndDepartmentNames;
import org.example.entity.UniversityService;

public class DemoScenario {
    public void Run() {
        UniversityService service = new UniversityService();

        service.createUniversity(1, "BSUIR");
        service.createFaculty("FCSaN");
        service.createDepartment(1, "Informatics", "FCSaN");
        FacultyAndDepartmentNames facultyAndDepartmentNames = new FacultyAndDepartmentNames("FCSaN", "Informatics");

        service.createTeacher(1, "Alexander", "Ivanov", facultyAndDepartmentNames);

        service.createStudent(1, "Matvey", "Khadorik",facultyAndDepartmentNames, 453503);

        service.createSubject(1, "OOP", facultyAndDepartmentNames, 1);
        service.enrollStudent(1, 1);
        service.assignGrade(1, 1,1, 10);

        service.createSubject(2, "Math", facultyAndDepartmentNames, 1);
        service.enrollStudent(1, 2);
        service.assignGrade(1, 1, 2, 8);

        double averageGrade = service.calculateAverageGrade(1);

        System.out.println(averageGrade);
    }
}
