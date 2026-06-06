package com.employee.address.dto.request;

import com.employee.address.constant.AddressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AddressRequestDTO {

    private Long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private AddressType addressType;
    private Boolean isPrimary;
}
