package com.common.common_library.exception;

import com.common.common_library.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found Exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(
            ResourceNotFoundException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Already Exists Exception
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleAlreadyExistsException(
            AlreadyExistsException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.CONFLICT.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // Bad Request Exception
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(
            BadRequestException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Business Exception
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(
            BusinessException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.UNPROCESSABLE_ENTITY.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    // Database Exception
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ApiResponse<Object>> handleDatabaseException(
            DatabaseException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // External Service Exception
    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<ApiResponse<Object>> handleExternalServiceException(
            ExternalServiceException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.SERVICE_UNAVAILABLE.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    // Forbidden Exception
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiResponse<Object>> handleForbiddenException(
            ForbiddenException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.FORBIDDEN.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    // Unauthorized Exception
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ApiResponse<Object>> handleUnauthorizedException(
            UnauthorizedException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.UNAUTHORIZED.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    // Validation Exception
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            ValidationException ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Generic Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGlobalException(
            Exception ex
    ) {

        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                ex.getMessage(),
                null,
                null
        );

        return new ResponseEntity<>(
                response,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}