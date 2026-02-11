package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addTeacher(Teacher teacher) {
        if(teacher == null || teachers.contains(teacher)) return;
        teachers.add(teacher);

        teacher.setDepartment(this);
    }

    public void addStudent(Student student) {
        if(student == null || students.contains(student)) return;
        students.add(student);
    }


    public void addCourse(Course course) {
        if(course == null || courses.contains(course)) return;
        courses.add(course);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course findCourseByCode(String code) {
        return courses.stream().filter(course -> course.getCode()
                .equals(code)).findFirst().orElse(null);
    }
}
