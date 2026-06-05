package com.employee.employee.model;

import com.common.common_library.entity.BaseEntity;
import com.employee.employee.constants.School;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "education_details" )
@Getter
@Setter
@NoArgsConstructor
public class EducationDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private School educationType;
    private String instituteName;
    private Float percentage;
}
