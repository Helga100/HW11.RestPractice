package com.example.hw11restptactice;

import com.example.hw11restptactice.entity.Student;
import com.example.hw11restptactice.repository.CoursesRepository;
import com.example.hw11restptactice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication

public class Hw11RestPtacticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw11RestPtacticeApplication.class, args);
    }

}

