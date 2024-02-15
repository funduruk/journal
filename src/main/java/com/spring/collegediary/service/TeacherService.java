package com.spring.collegediary.service;

import ch.qos.logback.classic.Logger;
import com.spring.collegediary.model.ImageModel;
import com.spring.collegediary.model.StudentModel;
import com.spring.collegediary.model.TeacherModel;
import com.spring.collegediary.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TeacherService {

    private final TeacherRepository teacherRepository;
    private Logger log;

    public List<TeacherModel> listTeacher(String lastName) {
        List<TeacherModel> teachers = teacherRepository.findAll();
        if(lastName != null) return teacherRepository.findByLastName(lastName);
        return teachers;
    }

    public void saveTeacher(TeacherModel teacher, MultipartFile file1) throws IOException {
        ImageModel image;
        if(file1.getSize() != 0){
            image = toImageEntity(file1);
            image.setPreviewImage(true);
            teacher.addImageToTeacher(image);
        }

        log.info("saving new {}", teacher);
        TeacherModel studentFromDb = teacherRepository.save(teacher);
        studentFromDb.setPreviewImageId(studentFromDb.getImages().get(0).getId());
        teacherRepository.save(teacher);
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

    public void deleteTeacher(Long id){

        teacherRepository.deleteById(id);
    }

    public TeacherModel getTeacherById(Long id){
        return teacherRepository.findById(id).orElse(null);
    }
}

