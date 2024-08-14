package com.pratikesh.college.management.CollegeManagementHomework.services.impl;

import com.pratikesh.college.management.CollegeManagementHomework.DTO.ProfessorDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.StudentDTO;
import com.pratikesh.college.management.CollegeManagementHomework.DTO.SubjectDTO;
import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.StudentEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import com.pratikesh.college.management.CollegeManagementHomework.repositories.StudentRepo;
import com.pratikesh.college.management.CollegeManagementHomework.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentRepo studentRepo;
    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        StudentEntity student = modelMapper.map(studentDTO, StudentEntity.class);
        StudentEntity saveEntity = studentRepo.save(student);
        return modelMapper.map(saveEntity, StudentDTO.class);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        isExistsById(studentId);
        Optional<StudentEntity> student = studentRepo.findById(studentId);
        return modelMapper.map(student, StudentDTO.class);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfessorDTO> getAssignedProfessorsToStudent(Long studentId) {
        isExistsById(studentId);
        List<ProfessorEntity> professorEntityList = studentRepo.findById(studentId)
                .get().getProfessors()
                .stream().toList();

        return professorEntityList.stream()
                .map(professorEntity -> modelMapper.map(professorEntity, ProfessorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubjectDTO> getAssignedSubjectsToStudent(Long studentId) {
        isExistsById(studentId);

        List<SubjectEntity> subjectEntityList = studentRepo.findById(studentId)
                .get().getSubjects()
                .stream().toList();

        return subjectEntityList.stream()
                .map(subjectEntity -> modelMapper.map(subjectEntity, SubjectDTO.class))
                .collect(Collectors.toList());
    }

    private void isExistsById(Long id){
        boolean isExists = studentRepo.existsById(id);
        if(!isExists) throw new RuntimeException("Student not found");
    }
}
