package com.employee.address.service;

import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;

public interface AddressService {
    public AddressResponseDTO saveEmployeeAddress(Long id, AddressRequestDTO addressRequestDTO);
}
