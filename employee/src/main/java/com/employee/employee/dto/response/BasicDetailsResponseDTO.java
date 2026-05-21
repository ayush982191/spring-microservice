package com.employee.employee.dto.response;

import com.employee.employee.dto.request.EducationDetailsRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicDetailsResponseDTO {
    private Long id;
    private String fatherName;
    private String motherName;
    private Integer totalSiblings;
    private EducationDetailsRequestDTO educationDetailsRequestDTO;
}
