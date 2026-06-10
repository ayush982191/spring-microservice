package com.employee.address.controller;

import com.common.common_library.dto.ApiResponse;
import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.common.common_library.dto.ApiResponse;


public interface AddressController {


    @Operation(summary = "Create Employee")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Employee Created Successfully")
    @PostMapping("/create/{id}")
    ResponseEntity<ApiResponse<AddressResponseDTO>> saveEmployeeAddress(
            @PathVariable Long id,
            @RequestBody AddressRequestDTO requestDTO
    );
}
