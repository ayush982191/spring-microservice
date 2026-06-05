package com.employee.employee.dto.response;

import com.employee.employee.dto.request.BasicDetailsRequestDTO;
import com.employee.employee.model.Skills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {
    private Long id;
    private String empName;
    private String empEmail;
    private String empCode;
    private String companyName;
    private List<SkillsResponseDTO> skills;
    private BasicDetailsResponseDTO details;
}
