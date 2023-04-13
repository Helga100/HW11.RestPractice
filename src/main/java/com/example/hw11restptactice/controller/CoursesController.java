package com.example.hw11restptactice.controller;

import com.example.hw11restptactice.entity.CourseDTO;
import com.example.hw11restptactice.entity.Course;
import com.example.hw11restptactice.service.CoursesServiceImpl;
import com.example.hw11restptactice.service.StudentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/courses")
public class CoursesController {

    @Autowired
    CoursesServiceImpl coursesService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/{studentId}")
    public ResponseEntity<CourseDTO> createCourseByStudentId(@PathVariable Long studentId, @RequestBody CourseDTO courseDTO) {
        if (courseDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Course course = modelMapper.map(courseDTO, Course.class);
        studentService.addNewCourseToStudent(studentId, course);
        return new ResponseEntity<>(courseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable Long studentId) {
        if (studentId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Course> courses = coursesService.findCoursesByStudentId(studentId);
        return new ResponseEntity<>(courses.stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList()), HttpStatus.OK);

    }

}
