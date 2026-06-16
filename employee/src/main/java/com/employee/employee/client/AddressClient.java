package com.employee.employee.client;

import com.common.common_library.dto.ApiResponse;
import com.employee.employee.client.dto.AddressRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Address", url="http://localhost:8081")
public interface AddressClient {
    @GetMapping("/address/internal/{id}")
     ApiResponse<AddressRequestDTO>  findByAddressId(@PathVariable Long id);


}


//@FeignClient(name = "employee", url = "http://localhost:8080")
//public interface EmployeeClient {
//
//    @GetMapping("/employees/{id}")
//    ApiResponse<?> getEmployeeById(@PathVariable Long id);
//}
