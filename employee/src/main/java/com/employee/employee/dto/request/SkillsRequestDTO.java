package com.employee.employee.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillsRequestDTO {
    Long id;
    private String skillName;
    private Float rating;
    private Float experience;
}
