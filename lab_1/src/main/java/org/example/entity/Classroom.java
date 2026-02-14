package org.example.entity;

public class Classroom {
    private final int id;
    private final int capacity;

    public Classroom(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
}
