package com.employee.employee.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillsResponseDTO {
    private Long id;
    private String skillName;
    private Float rating;
    private Float experience;
}
