package com.employee.address.config;

import com.common.common_library.dto.ApiResponse;
import com.common.common_library.exception.BadRequestException;
import com.common.common_library.exception.ResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    public FeignErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = "Unexpected error while calling service";

        try {
            if (response.body() != null) {
                ApiResponse<?> apiResponse = objectMapper.readValue(
                        response.body().asInputStream(),
                        ApiResponse.class
                );
                if (apiResponse.getMessage() != null) {
                    message = apiResponse.getMessage();
                }
            }
        } catch (Exception ignored) {}

        return switch (response.status()) {
            case 400 -> new BadRequestException(message);
            case 404 -> new ResourceNotFoundException(message);
            default  -> new RuntimeException(message);
        };
    }
}
