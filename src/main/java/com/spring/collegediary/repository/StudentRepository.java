package com.spring.collegediary.repository;

import com.spring.collegediary.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
        List<StudentModel> findByLastName(String lastName);
}
