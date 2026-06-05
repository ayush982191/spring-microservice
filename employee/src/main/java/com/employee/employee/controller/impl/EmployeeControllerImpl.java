package com.employee.employee.controller.impl;


import com.common.common_library.constant.ResponseMessage;
import com.common.common_library.constant.ResponseStatus;
import com.common.common_library.dto.ApiResponse;
import com.employee.employee.controller.EmployeeController;
import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import com.employee.employee.model.Employee;
import com.employee.employee.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeControllerImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @Override
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> createEmployee(EmployeeRequestDTO requestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.createEmployee(requestDTO);
        ApiResponse<EmployeeResponseDTO> response = new ApiResponse<>(
                ResponseStatus.CREATED.name(),
                ResponseMessage.CREATED.getMessage() ,
                employeeResponseDTO,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ApiResponse<Page<EmployeeResponseDTO>>> getAllEmployees(Integer page, Integer size) {
        Page<EmployeeResponseDTO> allEmployee = employeeService.getAllEmployees(page, size);
        ApiResponse<Page<EmployeeResponseDTO>> response = new ApiResponse<>(
                ResponseStatus.SUCCESS.name(),
                ResponseMessage.RETRIEVED.getMessage() ,
                allEmployee,
                null
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployeeById(Long id) {
         EmployeeResponseDTO responseDTO = employeeService.getEmployeeById(id);
        ApiResponse<EmployeeResponseDTO> response = new ApiResponse<>(
                ResponseStatus.SUCCESS.name(),
                ResponseMessage.RETRIEVED.getMessage() ,
                responseDTO,
                null
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> updateEmployeeById(Long id, EmployeeRequestDTO requestDTO) {
        EmployeeResponseDTO responseDTO = employeeService.updateEmployeeById(id,requestDTO);
        ApiResponse<EmployeeResponseDTO> response = new ApiResponse<>(
                ResponseStatus.SUCCESS.name(),
                ResponseMessage.RETRIEVED.getMessage() ,
                responseDTO,
                null
        );
        return new ResponseEntity<>(response,HttpStatus.OK);
        //        return null;
    }

    @Override
    public ResponseEntity<ApiResponse<Object>> deleteEmployee(Long id) {
        return null;
    }
}
