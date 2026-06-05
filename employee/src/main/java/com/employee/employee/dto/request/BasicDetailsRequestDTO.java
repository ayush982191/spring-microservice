package com.employee.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicDetailsRequestDTO {
    Long id;
    private String fatherName;
    private String motherName;
    private Integer totalSiblings;
    private List<EducationDetailsRequestDTO> educationDetailsRequestDTO;
}
