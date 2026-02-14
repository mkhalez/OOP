package org.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person{
    private final int id;
    private Group group;
    private final Map<Subject, Integer> subjectAssessment = new HashMap<>();

    public Student(String firstName, String secondName, int id, Group group) {
        super(firstName, secondName);
        this.id = id;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Map<Subject, Integer> getSubjectAssessment() {
        return subjectAssessment;
    }

    public void enrollToSubject(Subject subject) {
        subjectAssessment.put(subject, 0);
    }

    public void assignGrade(Grade grade) {
        subjectAssessment.put(grade.subject(), grade.value());
    }

    public double calculateAverageGrade() {
        List<Integer> grades = new ArrayList<>(subjectAssessment.values());
        int count = 0;
        double averageGrade = 0;

        for(var grade : grades) {
            if(grade != 0) {
                averageGrade += grade;
                count++;
            }
        }

        if(count == 0) return 0;
        return averageGrade / count;
    }
}
