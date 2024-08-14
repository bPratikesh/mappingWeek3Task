package com.pratikesh.college.management.CollegeManagementHomework.controllers;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.services.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorDTO createProfessor(@RequestBody ProfessorDTO professorDTO){
        return professorService.createProfessor(professorDTO);
    }

    @GetMapping("/{professorId}")
    public ProfessorDTO getProfessorById(@PathVariable Long professorId){
        return professorService.getProfessorById(professorId);
    }

    @GetMapping
    public List<ProfessorDTO> getAllProfessors(){
        return professorService.getAllProfessors();
    }
}
