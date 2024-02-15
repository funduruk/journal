package com.spring.collegediary.controller;

import com.spring.collegediary.model.StudentModel;
import com.spring.collegediary.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/")
    public String students(@RequestParam(name = "lastName", required = false) String lastName, Model model) {
        model.addAttribute("students", studentService.listStudents(lastName));
        return "index";
    }

    @GetMapping("/student/all")
    public String studentAll(@RequestParam(name = "lastName", required = false) String lastName, Model model) {
        model.addAttribute("students", studentService.listStudents(lastName));
        return "studentAll";
    }

    @GetMapping("/studentInfo/{id}")
    public String studentInfo(@PathVariable Long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("images", student.getImages());
        return "studentInfo";
    }

    @PostMapping("/student/create")
    public String createStudent(@RequestParam("file") MultipartFile file, StudentModel student) throws IOException {
        studentService.saveStudent(student, file);
        return "redirect:/";
    }

    @PostMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
