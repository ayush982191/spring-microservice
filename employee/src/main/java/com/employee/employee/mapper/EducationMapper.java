package com.employee.employee.mapper;

import com.employee.employee.dto.request.EducationDetailsRequestDTO;
import com.employee.employee.dto.response.EducationDetailsResponseDTO;
import com.employee.employee.model.EducationDetails;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface EducationMapper {
    EducationDetails toEntity(EducationDetailsRequestDTO educationDetailsRequestDTO);
    EducationDetailsResponseDTO toDTO(EducationDetails educationDetails);
}
