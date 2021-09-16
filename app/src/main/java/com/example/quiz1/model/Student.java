package com.example.quiz1.model;

public class Student
{
    private String name;
    private String code;
    private String grade;

    public Student() {
    }

    public Student(String name, String code, String grade) {
        this.name = name;
        this.code = code;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
