package org.example.scenario;

import org.example.entity.FacultyAndDepartmentNames;
import org.example.UniversityService;
import org.example.interfaces.Service;

public class DemoScenario {
    public void Run() {
        Service service = new UniversityService();

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

        int averageGrade = service.calculateAverageGrade(1, Integer.class);

        service.createSchedule(1, 1, 1, 453503, 1, 30);
        service.displaySchedules();

        System.out.println("Average grade of student id " + 1 +": " + averageGrade);
    }
}
