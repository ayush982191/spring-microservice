package com.employee.employee.dto.response;

import com.employee.employee.constants.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetailsResponseDTO {
    private Long id;
    private School educationType;
    private String instituteName;
    private Float percentage;
}
