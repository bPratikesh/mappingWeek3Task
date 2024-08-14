package com.pratikesh.college.management.CollegeManagementHomework.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pratikesh.college.management.CollegeManagementHomework.entities.AdmissionRecordEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.ProfessorEntity;
import com.pratikesh.college.management.CollegeManagementHomework.entities.SubjectEntity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    @JsonIgnore
    private AdmissionRecordDTO admittedStudent;
    @JsonIgnore
    private Set<SubjectDTO> subjects;
    @JsonIgnore
    private Set<ProfessorDTO> professors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
