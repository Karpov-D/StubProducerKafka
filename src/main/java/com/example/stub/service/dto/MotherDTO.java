package com.example.stub.service.dto;

public class MotherDTO {

    private String name;

    private int age;

    public MotherDTO() {
    }

    public MotherDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MotherDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
