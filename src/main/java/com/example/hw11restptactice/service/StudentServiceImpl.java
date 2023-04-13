package com.example.hw11restptactice.service;

import com.example.hw11restptactice.entity.Course;
import com.example.hw11restptactice.entity.Student;
import com.example.hw11restptactice.exception.StudentNotFoundException;
import com.example.hw11restptactice.repository.StudentRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService, InitializingBean {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void afterPropertiesSet() {
        studentRepository.saveAll(List.of(
                new Student("Jack","Nick",36),
                new Student("Joe","Nick",36),
                new Student("Sam","Nick",36)
        ));
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student is not found");
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Course addNewCourseToStudent(Long studentId, Course course) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student is no exception"));
        course.setStudent(foundStudent);
        foundStudent.addCourse(course);
        studentRepository.save(foundStudent);
        return course;
    }
}
