package org.example.dto;

import org.example.entities.Department;
import org.example.entities.Faculty;

public record FacultyAndDepartment(Faculty faculty, Department department) {
}
