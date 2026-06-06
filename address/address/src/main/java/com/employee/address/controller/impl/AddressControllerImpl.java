package com.employee.address.controller.impl;

import com.common.common_library.constant.ResponseMessage;
import com.common.common_library.constant.ResponseStatus;
import com.common.common_library.dto.ApiResponse;
import com.employee.address.controller.AddressController;
import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import org.springframework.http.ResponseEntity;

public class AddressControllerImpl implements AddressController  {
    @Override
    public ResponseEntity<ApiResponse<AddressResponseDTO>> saveEmployeeAddress(Long id, AddressRequestDTO requestDTO) {
        return null;
    }
}



//public ResponseEntity<ApiResponse<AddressResponseDTO>> saveEmployeeAddress(Long id, AddressRequestDTO requestDTO) {
//        AddressResponseDTO responseDTO = employeeService.updateEmployeeById(id,requestDTO);
//        ApiResponse<AddressResponseDTO> response = new ApiResponse<>(
//                ResponseStatus.SUCCESS.name(),
//                ResponseMessage.RETRIEVED.getMessage() ,
//                responseDTO,
//                null
//        );
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    return null;
//}