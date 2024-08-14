package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.AdmissionRecordDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.AdmissionRecordEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.StudentEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.AdmissionRecordRepo;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.StudentRepo;
import com.pratikesh.college.management.CollegeManagementHomework.services.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdmissionRecordServiceImpl implements AdmissionRecordService {

    private final ModelMapper modelMapper;
    private final AdmissionRecordRepo admissionRecordRepo;
    private final StudentRepo studentRepo;

    @Override
    public AdmissionRecordDTO admitStudent(AdmissionRecordDTO admissionRecordDTO) {
        AdmissionRecordEntity toSaveEntityFromDto = modelMapper.map(admissionRecordDTO, AdmissionRecordEntity.class);
        AdmissionRecordEntity savedStudentsEntity = admissionRecordRepo.save(toSaveEntityFromDto);
        return modelMapper.map(savedStudentsEntity, AdmissionRecordDTO.class);
    }

    @Override
    public List<AdmissionRecordDTO> getAllAdmittedStudent() {
        return admissionRecordRepo.findAll()
                .stream()
                .map(admissionRecordEntity -> modelMapper.map(admissionRecordEntity, AdmissionRecordDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdmissionRecordDTO getStudentById(Long admissionId) {
        isExistById(admissionId);
        Optional<AdmissionRecordEntity> admissionRecord = admissionRecordRepo.findById(admissionId);
        return modelMapper.map(admissionRecord, AdmissionRecordDTO.class);
    }

    @Override
    public boolean deleteStudent(Long admissionId) {
        isExistById(admissionId);
        admissionRecordRepo.deleteById(admissionId);
        return true;
    }

    @Override
    public AdmissionRecordDTO updateStudentDetails(Long admissionId, AdmissionRecordDTO admissionRecordDTO) {
        isExistById(admissionId);
        AdmissionRecordEntity admissionRecordEntity = modelMapper.map(admissionRecordDTO, AdmissionRecordEntity.class);
        admissionRecordEntity.setId(admissionId);

        AdmissionRecordEntity savedEntity = admissionRecordRepo.save(admissionRecordEntity);
        return modelMapper.map(savedEntity, AdmissionRecordDTO.class);
    }

    @Override
    public AdmissionRecordDTO assignStudentToAdmissionRecord(Long studentId, Long admissionId) {
        StudentEntity studentEntity = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));
        AdmissionRecordEntity admissionRecordEntity = admissionRecordRepo.findById(admissionId).orElseThrow(()-> new RuntimeException("Admission record not found "));

        admissionRecordEntity.setStudent(studentEntity);
        AdmissionRecordEntity toAssignStudentToAdmissionRecord = admissionRecordRepo.save(admissionRecordEntity);

        return modelMapper.map(toAssignStudentToAdmissionRecord, AdmissionRecordDTO.class);
    }



    private void isExistById(Long id){
        boolean isExist = admissionRecordRepo.existsById(id);
        if(!isExist) throw new RuntimeException("Admission record not found");
    }
}
