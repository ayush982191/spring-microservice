package com.employee.address.client;


import com.common.common_library.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "employee")
@FeignClient(name = "employee", url = "http://localhost:8080")
public interface EmployeeClient {

    @GetMapping("/employees/{id}")
    ApiResponse<?> getEmployeeById(@PathVariable Long id);


}
