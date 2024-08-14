package com.pratikesh.college.management.CollegeManagementHomework.repositories;

import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectEntity, Long> {
}
