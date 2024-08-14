package com.pratikesh.college.management.CollegeManagementHomework.controllers;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.services.StudentService;
import org.hibernate.annotations.CreationTimestamp;
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

    @GetMapping("/assignedProfessors/{studentId}")
    public List<ProfessorDTO> getAssignedProfessorsToStudent(@PathVariable Long studentId){
        return studentService.getAssignedProfessorsToStudent(studentId);
    }

    @GetMapping("/assignedSubjects/{studentId}")
    public List<SubjectDTO> getAssignedSubjectsToStudent(@PathVariable Long studentId){
        return studentService.getAssignedSubjectsToStudent(studentId);
    }
}
