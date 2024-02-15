package com.spring.collegediary.service;

import com.spring.collegediary.model.ImageModel;
import com.spring.collegediary.model.StudentModel;
import com.spring.collegediary.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    public List<StudentModel> listStudents(String lastName) {
        List<StudentModel> students = studentRepository.findAll();
        if(lastName != null) return studentRepository.findByLastName(lastName);
        return studentRepository.findAll();
    }
    @Transactional
    public void saveStudent(StudentModel student, MultipartFile file1) throws IOException {
        ImageModel image;
        if (file1.getSize() != 0) {
            image = toImageEntity(file1);
            image.setPreviewImage(true);
            student.addImageToStudent(image);
        }
        log.info("saving new {}", student);
        StudentModel studentFromDb = studentRepository.save(student);
        if (!studentFromDb.getImages().isEmpty()) {
            studentFromDb.setPreviewImageId(studentFromDb.getImages().get(0).getId());
            studentRepository.save(studentFromDb);
        }
    }

    private ImageModel toImageEntity(MultipartFile file) throws IOException {
        ImageModel image = new ImageModel();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    @Transactional
    public void deleteStudent(Long id){

        studentRepository.deleteById(id);
    }

    public StudentModel getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }
}
