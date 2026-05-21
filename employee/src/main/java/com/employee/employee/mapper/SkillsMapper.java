package com.employee.employee.mapper;

import com.employee.employee.dto.request.SkillsRequestDTO;
import com.employee.employee.dto.response.SkillsResponseDTO;
import com.employee.employee.model.Skills;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillsMapper {
    Skills toEntity(SkillsRequestDTO skillsRequestDTO);
    SkillsResponseDTO toDTO(Skills skills);
}
