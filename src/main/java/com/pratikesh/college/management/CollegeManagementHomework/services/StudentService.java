package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;

import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);
    public StudentDTO getStudentById(Long studentId);
    public List<StudentDTO> getAllStudents();
    public List<ProfessorDTO> getAssignedProfessorsToStudent(Long studentId);
    public List<SubjectDTO> getAssignedSubjectsToStudent(Long studentId);



}
