package com.employee.employee.mapper;


import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import com.employee.employee.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BasicDetailsMapper.class, SkillsMapper.class})
public interface EmployeeMapper {
    @Mapping(source = "basicDetailsRequestDTO", target = "basicDetails")
    Employee toEntity(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO toDTO(Employee employee);
}

