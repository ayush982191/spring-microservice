package com.employee.employee.repository;

import com.employee.employee.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skills,Long> {
}
