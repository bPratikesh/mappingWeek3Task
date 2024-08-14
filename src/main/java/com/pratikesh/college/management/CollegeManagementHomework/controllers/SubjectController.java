package com.pratikesh.college.management.CollegeManagementHomework.controllers;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.services.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.createSubject(subjectDTO);
    }

    @GetMapping("/{subjectId}")
    public SubjectDTO getSubjectById(@PathVariable Long subjectId){
        return subjectService.getSubjectById(subjectId);
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects(){
        return subjectService.getAllSubject();
    }

    @PutMapping("/{subjectId}/assignProfessor/{professorId}")
    public SubjectDTO assignProfessorToSubject(@PathVariable Long subjectId, @PathVariable Long professorId){
        return subjectService.assignProfessorToSubject(subjectId, professorId);
    }

    @GetMapping("/getAssignedProfessor/{subjectId}")
    public ProfessorDTO getAssignedProfessor(@PathVariable Long subjectId){
        return subjectService.getAssignedProfessor(subjectId);
    }

    @PutMapping("/{subjectId}/assignStudent/{studentId}")
    public SubjectDTO assignStudentToSubject(@PathVariable Long subjectId, @PathVariable Long studentId){
        return subjectService.assignStudentToSubject(subjectId, studentId);
    }

    @GetMapping("/getAssignedStudent/{subjectId}")
    public List<StudentDTO> getAssignedStudent(@PathVariable Long subjectId){
        return subjectService.getAssignedStudents(subjectId);
    }
}
