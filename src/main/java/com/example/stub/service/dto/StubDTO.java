package com.example.stub.service.dto;

import java.util.Arrays;

public class StubDTO {

    private String name;

    private int age;

    private MotherDTO mother;

    private String[] children;

    private boolean married;

    private boolean dog;

    public StubDTO() {
    }

    public StubDTO(String name, int age, MotherDTO mother, String[] children, boolean married, boolean dog) {
        this.name = name;
        this.age = age;
        this.mother = mother;
        this.children = children;
        this.married = married;
        this.dog = dog;
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

    public MotherDTO getMother() {
        return mother;
    }

    public void setMother(MotherDTO mother) {
        this.mother = mother;
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public boolean isDog() {
        return dog;
    }

    public void setDog(boolean dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "StubDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mother=" + mother +
                ", children=" + Arrays.toString(children) +
                ", married=" + married +
                ", dog=" + dog +
                '}';
    }

}
