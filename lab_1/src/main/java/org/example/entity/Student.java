package org.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
    private final int id;
    private int groupId;
    private final Map<Integer, Integer> subjectAssessment = new HashMap<>();

    public Student(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(Group group) {
        this.groupId = group.getId();
    }

    public Map<Integer, Integer> getSubjectAssessment() {
        return subjectAssessment;
    }

    public void enrollToSubject(Subject subject) {
        subjectAssessment.put(subject.getId(), 0);
    }

    public void assignGrade(Grade grade) {
        subjectAssessment.put(grade.getCourseId(), grade.getValue());
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
