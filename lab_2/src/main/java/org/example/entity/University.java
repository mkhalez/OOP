package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final int id;
    private final String name;
    private final List<Faculty> faculties = new ArrayList<>();

    public University(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public Faculty findFacultyByName(String name) {
        return faculties.stream().filter(faculty -> faculty.getName().
                equals(name)).findFirst().orElse(null);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
