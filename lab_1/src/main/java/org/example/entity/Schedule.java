package org.example.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private final int id;

    public Schedule(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void makeClassBusy(Classroom classroom, Subject subject, Group group) {
        classroom.setFree(false);
        System.out.println("Class: " + classroom.getId() + " is busy by group: "
                + group.getId() + " they will learn subject: " + subject.getDescription());
    }

}
