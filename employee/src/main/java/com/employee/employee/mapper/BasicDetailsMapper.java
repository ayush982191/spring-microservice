package com.employee.employee.mapper;

import com.employee.employee.dto.request.BasicDetailsRequestDTO;
import com.employee.employee.dto.response.BasicDetailsResponseDTO;
import com.employee.employee.model.BasicDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EducationMapper.class})
public interface BasicDetailsMapper {
    BasicDetails toEntity(BasicDetailsRequestDTO basicDetailsRequestDTO);
    BasicDetailsResponseDTO toDTO(BasicDetails basicDetails);
}
