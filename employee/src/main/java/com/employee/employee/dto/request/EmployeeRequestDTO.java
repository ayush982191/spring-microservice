package com.employee.employee.dto.request;

import com.employee.employee.model.Skills;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeRequestDTO {
    private String empName;
    private String empEmail;
    private String empCode;
    private String companyName;
    private List<SkillsRequestDTO> skills;
    private BasicDetailsRequestDTO basicDetailsRequestDTO;
}
