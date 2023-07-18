package com.project.model;

public class CounterRequest {
    private final int id;
    private final int add;

    public CounterRequest(int id, int add) {
        this.id = id;
        this.add = add;
    }

    public int getId() {
        return id;
    }

    public int getAdd() {
        return add;
    }

    @Override
    public String toString() {
        return "JsonModel{" +
                "id=" + id +
                ", add=" + add +
                '}';
    }
}
