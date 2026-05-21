package com.employee.employee.service.impl;

import com.common.common_library.dto.ApiResponse;
import com.common.common_library.exception.BadRequestException;
import com.employee.employee.controller.EmployeeController;
import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import com.employee.employee.mapper.EmployeeMapper;
import com.employee.employee.model.Employee;
import com.employee.employee.repository.EmployeeRepository;
import com.employee.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        // validate employee
     employeeRepository.findByEmpEmail(requestDTO.getEmpEmail())
                .ifPresent(e -> { throw new BadRequestException("Employee email already exists"); });
     Employee employee1 = employeeMapper.toEntity(requestDTO);
     Employee savedEmp = employeeRepository.save(employee1);
     return employeeMapper.toDTO(savedEmp);
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(Integer page,Integer size) {
        log.info("Coming inside getAllEmployees");
        Pageable pageable = PageRequest.of(page,size);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        log.info("page size = "+employees.getSize());
        return employees.map(employeeMapper::toDTO);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        return null;
    }

    @Override
    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO requestDTO) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }
}
