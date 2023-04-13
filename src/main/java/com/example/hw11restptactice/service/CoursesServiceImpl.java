package com.example.hw11restptactice.service;

import com.example.hw11restptactice.entity.Course;
import com.example.hw11restptactice.entity.Student;
import com.example.hw11restptactice.exception.StudentNotFoundException;
import com.example.hw11restptactice.repository.CoursesRepository;
import com.example.hw11restptactice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService {


    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Course createCourseByStudentId(Long studentId, Course course) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student is no exception"));
        course.setStudent(foundStudent);
        System.out.println(course.getStudent());
        return coursesRepository.save(course);
    }

    @Override
    public List<Course> findCoursesByStudentId(Long studentId) {
        return coursesRepository.findAllByStudentId(studentId);
    }
}
