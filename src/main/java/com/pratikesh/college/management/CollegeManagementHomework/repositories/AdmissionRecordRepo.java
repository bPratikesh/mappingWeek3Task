package com.pratikesh.college.management.CollegeManagementHomework.repositories;

import com.pratikesh.college.management.CollegeManagementHomework.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecordEntity, Long> {

}
