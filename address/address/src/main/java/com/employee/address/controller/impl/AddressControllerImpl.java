package com.employee.address.controller.impl;

import com.common.common_library.constant.ResponseMessage;
import com.common.common_library.constant.ResponseStatus;
import com.common.common_library.dto.ApiResponse;
import com.employee.address.controller.AddressController;
import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import com.employee.address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
public class AddressControllerImpl implements AddressController  {
    private final AddressService addressService;
    AddressControllerImpl(AddressService addressService){
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<ApiResponse<AddressResponseDTO>> saveEmployeeAddress(Long id, AddressRequestDTO requestDTO) {
                AddressResponseDTO responseDTO = addressService.saveEmployeeAddress (id,requestDTO);
        ApiResponse<AddressResponseDTO> response = new ApiResponse<>(
                ResponseStatus.SUCCESS.name(),
                ResponseMessage.RETRIEVED.getMessage(),
                responseDTO,
                null
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public  ResponseEntity<ApiResponse<AddressResponseDTO>> findByAddressId(
            @PathVariable Long addressId
    ){
        AddressResponseDTO responseDTO = addressService.findByAddressId(addressId);
                ApiResponse<AddressResponseDTO> address = new ApiResponse<>(
                ResponseStatus.SUCCESS.name(),
                ResponseMessage.RETRIEVED.getMessage() ,
                        responseDTO,
                null
        );
        return new ResponseEntity<>(address, HttpStatus.OK);

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