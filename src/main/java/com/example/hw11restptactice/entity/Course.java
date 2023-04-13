package com.example.hw11restptactice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int durationInMonths;
    private int priceInUah;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    @JsonIgnore
    private Student student;

}
