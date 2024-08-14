package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;

import java.util.List;

public interface SubjectService {

    public SubjectDTO createSubject(SubjectDTO subjectDTO);
    public SubjectDTO getSubjectById(Long subjectId);
    public List<SubjectDTO> getAllSubject();
}
