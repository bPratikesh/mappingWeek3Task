package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.StudentEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.ProfessorRepo;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.StudentRepo;
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
    private final StudentRepo studentRepo;

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

    @Override
    public List<StudentDTO> getAssignedStudents(Long professorId) {
        isExistById(professorId);
        List<StudentEntity> studentEntityList = professorRepo.findById(professorId)
                .get()
                .getStudents()
                .stream().toList();

        return studentEntityList.stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> getAssignedSubjects(Long professorId) {
        isExistById(professorId);
        List<SubjectEntity> subjectEntityList = professorRepo.findById(professorId)
                .get()
                .getSubjects()
                .stream().toList();

        return subjectEntityList.stream()
                .map(subjectEntity -> modelMapper.map(subjectEntity, SubjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO assignStudentToProfessor(Long studentId, Long professorId) {
        StudentEntity studentEntity = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));
        ProfessorEntity professorEntity = professorRepo.findById(professorId).orElseThrow(()->new RuntimeException("Professor not found"));

        professorEntity.getStudents().add(studentEntity);
        //professorEntity.setStudents(studentEntity);

        ProfessorEntity toAssignStudentToProfessor = professorRepo.save(professorEntity);
        return modelMapper.map(toAssignStudentToProfessor, ProfessorDTO.class);
    }

    private void isExistById(Long id){
        boolean isExist = professorRepo.existsById(id);
        if(!isExist) throw new RuntimeException("Professor not found");
    }
}
