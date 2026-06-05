package com.employee.employee.mapper;

import com.employee.employee.dto.request.BasicDetailsRequestDTO;
import com.employee.employee.dto.response.BasicDetailsResponseDTO;
import com.employee.employee.model.BasicDetails;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EducationMapper.class})
public interface BasicDetailsMapper {

    @Mapping(source = "educationDetailsRequestDTO", target = "educationDetails")
    BasicDetails toEntity(BasicDetailsRequestDTO basicDetailsRequestDTO);
    @Mapping(source = "educationDetails", target = "educationDetails")
    BasicDetailsResponseDTO toDTO(BasicDetails basicDetails);
}

