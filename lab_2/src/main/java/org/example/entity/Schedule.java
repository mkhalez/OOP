package org.example.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Schedule {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
    private final int id;
    private final Subject subject;
    private final Teacher teacher;
    private final Group group;
    private final Classroom classroom;
    private final LocalDateTime date;

    public Schedule(int id, Subject subject, Teacher teacher,
                    Group group, Classroom classroom, LocalDateTime date) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.group = group;
        this.classroom = classroom;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Subject getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Group getGroup() {
        return group;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Schedule: " +
                "id=" + id +
                ", subjectId=" + subject +
                ", teacherId=" + teacher +
                ", groupId=" + group +
                ", classroomId=" + classroom +
                ", date=" + date.format(dateTimeFormatter);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return id == schedule.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
