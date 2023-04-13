package com.example.hw11restptactice.service;

import com.example.hw11restptactice.entity.Course;
import com.example.hw11restptactice.entity.Student;

public interface StudentService {


    void delete(Long id);

    Student createStudent(Student student);


    Course addNewCourseToStudent(Long studentId, Course course);
}
