package com.employee.employee.controller;

import com.common.common_library.dto.ApiResponse;
import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
public interface EmployeeController {

    @Operation(summary = "Create Employee")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Employee Created Successfully")
    @PostMapping("/create")
    ResponseEntity<ApiResponse<EmployeeResponseDTO>> createEmployee(
            @RequestBody EmployeeRequestDTO requestDTO
    );

    @Operation(summary = "Get All Employees")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/all")

    ResponseEntity<ApiResponse<Page<EmployeeResponseDTO>>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    );

    @Operation(summary = "Get Employee By Id")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success")
    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployeeById(
            @PathVariable Long id
    );

    @Operation(summary = "Update Employee")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Employee Updated Successfully")
    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<EmployeeResponseDTO>> updateEmployeeById(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO requestDTO
    );

    @Operation(summary = "Delete Employee")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Employee Deleted Successfully")
    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<Object>> deleteEmployee(
            @PathVariable Long id
    );
}