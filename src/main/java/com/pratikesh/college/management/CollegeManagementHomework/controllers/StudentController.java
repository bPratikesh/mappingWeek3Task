package com.pratikesh.college.management.CollegeManagementHomework.controllers;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/{studentId}")
    public StudentDTO getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudents();
    }

}
