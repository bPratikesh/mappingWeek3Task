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

    @GetMapping("/{admissionId}")
    public AdmissionRecordDTO getStudentById(@PathVariable Long admissionId){
        return admissionRecordService.getStudentById(admissionId);
    }

    @DeleteMapping("/{admissionId}")
    public boolean deleteStudentById(@PathVariable Long admissionId){
        return admissionRecordService.deleteStudent(admissionId);
    }
    @PutMapping("/{admissionId}")
    public AdmissionRecordDTO updateStudentDetailsById(@PathVariable Long admissionId, @RequestBody AdmissionRecordDTO admissionRecordDTO){
        return admissionRecordService.updateStudentDetails(admissionId, admissionRecordDTO);
    }

    @PutMapping("/{studentId}/admissionRecord/{admissionId}")
    public AdmissionRecordDTO assignStudentToAdmissionRecord(@PathVariable Long studentId, @PathVariable Long admissionId){
        return admissionRecordService.assignStudentToAdmissionRecord(studentId,admissionId);
    }

}
