package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.SubjectRepo;
import com.pratikesh.college.management.CollegeManagementHomework.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final ModelMapper modelMapper;
    private final SubjectRepo subjectRepo;
    @Override
    public SubjectDTO createSubject(SubjectDTO subjectDTO) {
        SubjectEntity subjectEntity = modelMapper.map(subjectDTO, SubjectEntity.class);
        SubjectEntity saveEntity = subjectRepo.save(subjectEntity);
        return modelMapper.map(saveEntity, SubjectDTO.class);
    }

    @Override
    public SubjectDTO getSubjectById(Long subjectId) {
        isExistsById(subjectId);
        Optional<SubjectEntity> subject = subjectRepo.findById(subjectId);
        return modelMapper.map(subject, SubjectDTO.class);
    }

    @Override
    public List<SubjectDTO> getAllSubject() {
        return subjectRepo.findAll()
                .stream()
                .map(subjectEntity -> modelMapper.map(subjectEntity, SubjectDTO.class))
                .collect(Collectors.toList());
    }

    private void isExistsById(Long id){
        boolean isExists = subjectRepo.existsById(id);
        if(!isExists) throw new RuntimeException("Subject not found");
    }
}
