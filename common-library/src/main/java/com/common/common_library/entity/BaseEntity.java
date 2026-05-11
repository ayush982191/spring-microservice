package com.common.common_library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;


@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    private Integer createdBy;
    private Integer updatedBy;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private Instant updatedAt;
}
