package com.example.hw11restptactice.service;

import com.example.hw11restptactice.entity.Course;

import java.util.List;

public interface    CoursesService {

    Course createCourseByStudentId(Long id, Course course);

    List<Course> findCoursesByStudentId(Long studentId);
}
