package com.employee.address.service;

import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import com.employee.address.model.Address;

public interface AddressService {
    public AddressResponseDTO saveEmployeeAddress(Long id, AddressRequestDTO addressRequestDTO);
    public AddressResponseDTO findByAddressId(Long id);
}
