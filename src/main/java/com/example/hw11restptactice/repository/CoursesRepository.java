package com.example.hw11restptactice.repository;

import com.example.hw11restptactice.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Long> {

    List<Course> findAllByStudentId(Long studentId);
}
