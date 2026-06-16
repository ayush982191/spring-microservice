package com.employee.address.controller;

import com.common.common_library.dto.ApiResponse;
import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.common.common_library.dto.ApiResponse;


public interface AddressController {


    @Operation(summary = "Save Address")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Employee Created Successfully")
    @PostMapping("/create/{id}")
    ResponseEntity<ApiResponse<AddressResponseDTO>> saveEmployeeAddress(
            @PathVariable Long id,
            @RequestBody AddressRequestDTO requestDTO
    );

    @Operation(summary = "get Address")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Employee Created Successfully")
    @GetMapping("/address/{id}")
    ResponseEntity<ApiResponse<AddressResponseDTO>> findByAddressId(
            @PathVariable Long id
    );
//    /address/internal/

    @Operation(summary = "get Address")
    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Employee Created Successfully")
    @GetMapping("/address/internal/{id}")
    ResponseEntity<ApiResponse<AddressResponseDTO>> findByAddressIdInternal(
            @PathVariable Long id
    );



}
