package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;

import java.util.List;

public interface SubjectService {

    public SubjectDTO createSubject(SubjectDTO subjectDTO);
    public SubjectDTO getSubjectById(Long subjectId);
    public List<SubjectDTO> getAllSubject();
    public SubjectDTO assignProfessorToSubject(Long subjectId, Long professorId);
    public ProfessorDTO getAssignedProfessor(Long subjectId);
    public SubjectDTO assignStudentToSubject(Long subjectId, Long studentId);
    public List<StudentDTO> getAssignedStudents(Long subjectId);

}
