package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.AdmissionRecordDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.AdmissionRecordEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.AdmissionRecordRepo;
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
    public AdmissionRecordDTO getStudentById(Long studentId) {
        isExistById(studentId);
        Optional<AdmissionRecordEntity> admissionRecord = admissionRecordRepo.findById(studentId);
        return modelMapper.map(admissionRecord, AdmissionRecordDTO.class);
    }

    private void isExistById(Long id){
        boolean isExist = admissionRecordRepo.existsById(id);
        if(!isExist) throw new RuntimeException("Admission record not found");
    }

}
