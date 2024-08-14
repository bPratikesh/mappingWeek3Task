package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;

import java.util.List;

public interface ProfessorService {

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO);
    public ProfessorDTO getProfessorById(Long professorId);
    public List<ProfessorDTO> getAllProfessors();
    public List<StudentDTO> getAssignedStudents(Long professorId);
    public List<SubjectDTO> getAssignedSubjects(Long professorId);
    public ProfessorDTO assignStudentToProfessor(Long studentId, Long professorId);
}
