package com.pratikesh.college.management.CollegeManagementHomework.repositories;

import com.pratikesh.college.management.CollegeManagementHomework.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
}
