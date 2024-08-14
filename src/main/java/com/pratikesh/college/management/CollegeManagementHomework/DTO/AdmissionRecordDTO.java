package com.pratikesh.college.management.CollegeManagementHomework.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionRecordDTO {

    private Long id;
    private Integer fees;

}
