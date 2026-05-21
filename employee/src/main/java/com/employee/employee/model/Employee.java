package com.employee.employee.model;


import com.common.common_library.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    @Column(unique = true,nullable = false)
    private String empEmail;
    @Column(unique = true,nullable = false)
    private String empCode;
    private String companyName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basis_details_id")
    private BasicDetails basicDetails;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_skill",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Skills> skills = new ArrayList<>();

}
