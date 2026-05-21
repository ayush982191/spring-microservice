package com.employee.employee.mapper;

import com.employee.employee.dto.request.EducationDetailsRequestDTO;
import com.employee.employee.dto.response.EducationDetailsResponseDTO;
import com.employee.employee.model.EducationDetails;

public interface EducationMapper {
    EducationDetails toEntity(EducationDetailsRequestDTO educationDetailsRequestDTO);
    EducationDetailsResponseDTO toDTO(EducationDetails educationDetails);
}
