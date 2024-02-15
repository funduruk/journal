package com.spring.collegediary.controller;

import com.spring.collegediary.model.StudentModel;
import com.spring.collegediary.model.TeacherModel;
import com.spring.collegediary.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/teacher/all")
        public String teacherAll(@RequestParam(name = "lastName", required = false)String lastName, Model model){
            model.addAttribute("teachers", teacherService.listTeacher(lastName));
            return "teacherAll";
    }

    @GetMapping("/teacherInfo/{id}")
    public String teacherInfo(@PathVariable Long id, Model model ){
        TeacherModel teacher = teacherService.getTeacherById(id);
        model.addAttribute("student", teacher);
        model.addAttribute("images", teacher.getImages());
        return "teacherInfo";
    }

    @PostMapping("/teacher/create")
    public String createTeacher(@RequestParam("file") MultipartFile file, TeacherModel teacher, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            return "errorPage";
        }
        teacherService.saveTeacher(teacher, file);
        return "redirect:/";
    }
    @PostMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id){
         teacherService.deleteTeacher(id);
        return "redirect:/";
    }

}
