package com.employee.address.mapper;

import com.employee.address.dto.request.AddressRequestDTO;
import com.employee.address.dto.response.AddressResponseDTO;
import com.employee.address.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address toEntity(AddressRequestDTO addressRequestDTO);

    AddressResponseDTO toDTO(Address address);

    void updateEntity(AddressRequestDTO requestDTO, @MappingTarget Address address);
}

