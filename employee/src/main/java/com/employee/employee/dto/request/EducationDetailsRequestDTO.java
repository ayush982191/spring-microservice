package com.employee.employee.dto.request;

import com.employee.employee.constants.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetailsRequestDTO {
    Long id;
    private School educationType;
    private String instituteName;
    private Float percentage;
}
