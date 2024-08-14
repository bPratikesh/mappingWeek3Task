package com.pratikesh.college.management.CollegeManagementHomework.services;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.AdmissionRecordDTO;

import java.util.List;

public interface AdmissionRecordService {

    public AdmissionRecordDTO admitStudent(AdmissionRecordDTO admissionRecordDTO);
    public List<AdmissionRecordDTO> getAllAdmittedStudent();
    public AdmissionRecordDTO getStudentById(Long studentId);

  /*  TODO
    AdmissionRecordDTO assignStudentToAdmissionRecord(Long studentId, Long admissionId);*/
}
