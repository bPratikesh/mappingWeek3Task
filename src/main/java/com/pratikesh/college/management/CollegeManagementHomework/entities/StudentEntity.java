package com.pratikesh.college.management.CollegeManagementHomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AdmissionRecordEntity admittedStudent;

    @ManyToMany(mappedBy = "students")
    private Set<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "students")
    private Set<ProfessorEntity> professors;
}
