package com.example.hw11restptactice.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity

@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Course> courseList;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void addCourse(Course course) {
        this.courseList.add(course);
    }

    public void deleteCourse(Course course) {
        this.courseList.remove(course);
    }

}
