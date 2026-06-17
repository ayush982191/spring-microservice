package com.employee.address.dto.response;

import com.employee.address.config.views.AddressViews;
import com.employee.address.constant.AddressType;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressResponseDTO {
    @JsonView(AddressViews.Public.class)
    private Long id;
    @JsonView(AddressViews.Public.class)
    private String street;
    @JsonView(AddressViews.Public.class)
    private String city;
    @JsonView(AddressViews.Public.class)
    private String state;
    @JsonView(AddressViews.Public.class)
    private String country;
    @JsonView(AddressViews.Public.class)
    private String zipCode;
    @JsonView(AddressViews.Public.class)
    private AddressType addressType;
    @JsonView(AddressViews.Public.class)
    private Boolean isPrimary;
    @JsonView(AddressViews.Internal.class)
    private Long employeeId;
}
