package org.example.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University {
    private final String name;
    private final List<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void addFaculty(Faculty faculty) {
        if (faculties.contains(faculty)) return;
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
}
