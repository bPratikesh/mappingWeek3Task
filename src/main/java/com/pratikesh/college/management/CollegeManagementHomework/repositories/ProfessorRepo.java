package com.pratikesh.college.management.CollegeManagementHomework.repositories;

import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<ProfessorEntity, Long> {
}
