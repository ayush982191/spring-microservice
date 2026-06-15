package com.employee.employee.service;
import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import com.employee.employee.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO);

    Page<EmployeeResponseDTO> getAllEmployees(Integer page, Integer size);

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployeeById(
            Long id,
            EmployeeRequestDTO requestDTO
    );

    void deleteEmployee(Long id);

    public Employee findByIdOrAddress(Long empId, Long addressId);

}