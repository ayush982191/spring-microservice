package com.employee.employee.model;

import com.common.common_library.entity.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family")
public class BasicDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fatherName;
    private String motherName;
    private Integer totalSiblings;

    private List<EducationDetails> educationDetails = new ArrayList<>();

}
