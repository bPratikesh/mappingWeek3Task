package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.ProfessorRepo;
import com.pratikesh.college.management.CollegeManagementHomework.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ModelMapper modelMapper;
    private final ProfessorRepo professorRepo;

    @Override
    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        ProfessorEntity professorEntity = modelMapper.map(professorDTO, ProfessorEntity.class);
        ProfessorEntity saveEntity = professorRepo.save(professorEntity);
        return modelMapper.map(saveEntity, ProfessorDTO.class);
    }

    @Override
    public ProfessorDTO getProfessorById(Long professorId) {
        isExistById(professorId);
        Optional<ProfessorEntity> professor = professorRepo.findById(professorId);
        return modelMapper.map(professor, ProfessorDTO.class);
    }

    @Override
    public List<ProfessorDTO> getAllProfessors() {
        return professorRepo.findAll()
                .stream()
                .map(professorEntity -> modelMapper.map(professorEntity, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    private void isExistById(Long id){
        boolean isExist = professorRepo.existsById(id);
        if(!isExist) throw new RuntimeException("Professor not found");
    }
}
