package com.pratikesh.college.management.CollegeManagementHomework.controllers;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.AdmissionRecordDTO;
import com.pratikesh.college.management.CollegeManagementHomework.services.AdmissionRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @PostMapping
    public AdmissionRecordDTO admitStudent(@RequestBody AdmissionRecordDTO admissionRecordDTO){
        return admissionRecordService.admitStudent(admissionRecordDTO);
    }

    @GetMapping
    public List<AdmissionRecordDTO> getAllStudent(){
        return admissionRecordService.getAllAdmittedStudent();
    }

    @GetMapping("/{studentId}")
    public AdmissionRecordDTO getStudentById(@PathVariable Long studentId){
        return admissionRecordService.getStudentById(studentId);
    }
}
