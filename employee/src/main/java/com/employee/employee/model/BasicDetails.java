package com.employee.employee.model;

import com.common.common_library.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "basic_details")
@Getter
@Setter
@NoArgsConstructor
public class BasicDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fatherName;
    private String motherName;
    private Integer totalSiblings;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "education_details_id")
    private List<EducationDetails> educationDetails = new ArrayList<>();

}
