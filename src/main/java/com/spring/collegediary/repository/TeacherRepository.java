package com.spring.collegediary.repository;

import com.spring.collegediary.model.StudentModel;
import com.spring.collegediary.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
    List<TeacherModel> findByLastName(String lastName);
}
