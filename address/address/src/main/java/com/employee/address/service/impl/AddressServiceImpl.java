package com.employee.address.service.impl;

import com.common.common_library.exception.ResourceNotFoundException;
import com.employee.address.client.EmployeeClient;
import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import com.employee.address.mapper.AddressMapper;
import com.employee.address.model.Address;
import com.employee.address.repository.AddressRepository;
import com.employee.address.service.AddressService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final EmployeeClient employeeClient;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    AddressServiceImpl(AddressMapper addressMapper,EmployeeClient employeeClient,AddressRepository addressRepository){
        this.employeeClient = employeeClient;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressResponseDTO saveEmployeeAddress(Long id, AddressRequestDTO addressRequestDTO){
        try{
            employeeClient.getEmployeeById(id);
            Address address = addressMapper.toEntity(addressRequestDTO);
            address.setEmployeeId(id);
            addressRepository.save(address);
            return addressMapper.toDTO(address);
        }catch (FeignException.NotFound e){
            throw new ResourceNotFoundException("Employee not found with id check " + id);
        }
    }
}
