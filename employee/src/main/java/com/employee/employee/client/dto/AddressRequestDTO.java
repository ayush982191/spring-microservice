package com.employee.employee.client.dto;

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
    private Boolean isPrimary;
    private Long employeeId;
}
