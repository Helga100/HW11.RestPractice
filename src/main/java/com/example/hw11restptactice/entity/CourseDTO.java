package com.example.hw11restptactice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private String name;
    private int durationInMonths;
    private int priceInUah;
}
