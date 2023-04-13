package com.example.hw11restptactice.repository;

import com.example.hw11restptactice.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
