package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.StudentEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.ProfessorRepo;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.StudentRepo;
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
    private final ProfessorRepo professorRepo;
    private final StudentRepo studentRepo;
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

    @Override
    public SubjectDTO assignProfessorToSubject(Long subjectId, Long professorId) {
        ProfessorEntity professorEntity = professorRepo.findById(professorId).orElseThrow(()-> new RuntimeException("Professor not found"));
        SubjectEntity subjectEntity = subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("Subject not found"));

        subjectEntity.setProfessor(professorEntity);
        professorEntity.getSubjects().add(subjectEntity);

        SubjectEntity toSaveEntity = subjectRepo.save(subjectEntity);
        return modelMapper.map(toSaveEntity, SubjectDTO.class);
    }

    @Override
    public ProfessorDTO getAssignedProfessor(Long subjectId) {
        isExistsById(subjectId);

        ProfessorEntity professorEntity = subjectRepo.findById(subjectId).get().getProfessor();
        return modelMapper.map(professorEntity, ProfessorDTO.class);

    }

    @Override
    public SubjectDTO assignStudentToSubject(Long subjectId, Long studentId) {
        SubjectEntity subjectEntity = subjectRepo.findById(subjectId).orElseThrow(()-> new RuntimeException("Subject not found"));
        StudentEntity studentEntity = studentRepo.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));

        subjectEntity.getStudents().add(studentEntity);
        studentEntity.getSubjects().add(subjectEntity);

        SubjectEntity subject = subjectRepo.save(subjectEntity);
        return modelMapper.map(subject, SubjectDTO.class);
    }

    @Override
    public List<StudentDTO> getAssignedStudents(Long subjectId) {
        isExistsById(subjectId);

        List<StudentEntity> studentEntities = subjectRepo.findById(subjectId).get()
                                                .getStudents().stream().toList();

        return studentEntities.stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    private void isExistsById(Long id){
        boolean isExists = subjectRepo.existsById(id);
        if(!isExists) throw new RuntimeException("Subject not found");
    }
}
