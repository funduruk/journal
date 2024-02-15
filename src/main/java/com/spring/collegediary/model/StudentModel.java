package com.spring.collegediary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "numberPhone")
    private String numberPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "course")
    private int course;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
    mappedBy = "studentModel")
    private List<ImageModel> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;


    @PrePersist
    private void init(){
        dateOfCreated = LocalDateTime.now();
    }

    public void addImageToStudent(ImageModel image){
        if (this.images == null) {
            this.images = new ArrayList<>();
        }
        this.images.add(image);
    }


}
