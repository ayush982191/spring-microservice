package com.employee.employee.dto.request;

import com.employee.employee.model.Skills;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {
    private Long id;
    private String empName;
    private String empEmail;
    private String empCode;
    private String companyName;
    private List<SkillsRequestDTO> skills;
    private BasicDetailsRequestDTO basicDetailsRequestDTO;
}
