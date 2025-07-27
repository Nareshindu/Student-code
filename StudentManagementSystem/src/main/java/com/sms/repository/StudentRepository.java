package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Optional: Add custom methods if needed
}
