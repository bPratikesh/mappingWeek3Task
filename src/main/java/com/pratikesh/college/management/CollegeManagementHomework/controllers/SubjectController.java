package com.pratikesh.college.management.CollegeManagementHomework.controllers;

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
}
