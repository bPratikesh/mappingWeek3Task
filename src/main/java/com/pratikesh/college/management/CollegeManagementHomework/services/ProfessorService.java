package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;

import java.util.List;

public interface ProfessorService {

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO);
    public ProfessorDTO getProfessorById(Long professorId);
    public List<ProfessorDTO> getAllProfessors();
}
