package com.employee.employee.model;

import com.common.common_library.entity.BaseEntity;
import com.employee.employee.constants.School;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "education_details" )
public class EducationDetails extends BaseEntity {
    @Id
    private Long id;
    private School educationType;
    private String instituteName;
    private Float percentage;
}
