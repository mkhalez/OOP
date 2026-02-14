package org.example.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
    private final int id;
    private final int subjectId;
    private final int teacherId;
    private final int groupId;
    private final int classroomId;
    private final LocalDateTime date;

    public Schedule(int id, Subject subject, Teacher teacher,
                    Group group, Classroom classroom, LocalDateTime date) {
        this.id = id;
        this.subjectId = subject.getId();
        this.teacherId = teacher.getId();
        this.groupId = group.getId();
        this.classroomId = classroom.getId();
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Schedule: " +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                ", groupId=" + groupId +
                ", classroomId=" + classroomId +
                ", date=" + date.format(dateTimeFormatter);
    }
}
