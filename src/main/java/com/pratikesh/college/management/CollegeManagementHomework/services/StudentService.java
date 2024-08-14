package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import java.util.List;

public interface StudentService {

    public StudentDTO createStudent(StudentDTO studentDTO);
    public StudentDTO getStudentById(Long studentId);
    public List<StudentDTO> getAllStudents();


}
