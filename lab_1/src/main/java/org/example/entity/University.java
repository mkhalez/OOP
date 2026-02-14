package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final int id;
    private final String name;
    private final List<Integer> facultyIds = new ArrayList<>();

    public University(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Integer> getFaculties() {
        return facultyIds;
    }

    public void addFaculty(Faculty faculty) {
        facultyIds.add(faculty.getId());
    }

    public void removeFaculty(int facultyId) {
        facultyIds.remove(facultyId);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getFacultyIds() {
        return facultyIds;
    }
}
