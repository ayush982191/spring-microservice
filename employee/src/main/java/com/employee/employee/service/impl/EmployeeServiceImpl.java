package com.employee.employee.service.impl;

import com.common.common_library.dto.ApiResponse;
import com.common.common_library.exception.BadRequestException;
import com.common.common_library.exception.ResourceNotFoundException;
import com.employee.employee.controller.EmployeeController;
import com.employee.employee.dto.request.EmployeeRequestDTO;
import com.employee.employee.dto.request.SkillsRequestDTO;
import com.employee.employee.dto.response.EmployeeResponseDTO;
import com.employee.employee.mapper.EmployeeMapper;
import com.employee.employee.mapper.SkillsMapper;
import com.employee.employee.model.Employee;
import com.employee.employee.model.Skills;
import com.employee.employee.repository.EmployeeRepository;
import com.employee.employee.repository.SkillRepository;
import com.employee.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final SkillRepository skillRepository;
    private final SkillsMapper skillsMapper;

    EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper,SkillRepository skillRepository,SkillsMapper skillsMapper){
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.skillRepository = skillRepository;
        this.skillsMapper = skillsMapper;
    }

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        // validate employee
//     employeeRepository.findByEmpEmail(requestDTO.getEmpEmail())
//                .ifPresent(e -> { throw new BadRequestException("Employee email already exists"); });
//     employeeRepository.findByEmpCode(requestDTO.getEmpCode())
//             .ifPresent(e-> {throw new BadRequestException("Employee code already exist"); });
        employeeRepository.findByEmpEmailOrEmpCode(requestDTO.getEmpEmail(),requestDTO.getEmpCode())
                .ifPresent(e->{ throw new BadRequestException("Check email or employee code");});
     Employee employee1 = employeeMapper.toEntity(requestDTO);
     Employee savedEmp = employeeRepository.save(employee1);
     return employeeMapper.toDTO(savedEmp);
    }

    @Override
    public Page<EmployeeResponseDTO> getAllEmployees(Integer page,Integer size) {
        log.info("Coming inside getAllEmployees");
        Pageable pageable = PageRequest.of(page,size);
        Page<Employee> employees = employeeRepository.findAll(pageable);
        log.info("page size = "+employees.getSize());
        return employees.map(employeeMapper::toDTO);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid employee id");
        }
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id "+id));
        return  employeeMapper.toDTO(employee);
    }
    @Override
    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO requestDTO) {
        log.info("Entering inside updateEmployee");
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Employee Id");
        }

        Optional<Employee> existingEmployee = employeeRepository.findByEmpEmailOrEmpCode(requestDTO.getEmpEmail(), requestDTO.getEmpCode());
        if (existingEmployee.isPresent() && !Objects.equals(existingEmployee.get().getId(), requestDTO.getId())) {
            throw new BadRequestException("email or code already exist");
        }

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID " + id));

        // update basic fields
        employeeMapper.updateEntity(requestDTO, employee);

        // update skills
        if (requestDTO.getSkills() != null) {
            List<Skills> updatedSkills = new ArrayList<>();
            requestDTO.getSkills().forEach(skillDTO -> {
                if (skillDTO.getId() != null) {
                    // load existing and update its values
                    Skills existing = skillRepository.findById(skillDTO.getId())
                            .orElseThrow(() -> new ResourceNotFoundException("Skill not found with ID " + skillDTO.getId()));
                    existing.setSkillName(skillDTO.getSkillName());
                    existing.setRating(skillDTO.getRating());
                    existing.setExperience(skillDTO.getExperience());
                    updatedSkills.add(existing);
                } else {
                    // new skill
                    updatedSkills.add(skillsMapper.toEntity(skillDTO));
                }
            });
            employee.setSkills(skillRepository.saveAll(updatedSkills));
        }
        return employeeMapper.toDTO(employeeRepository.save(employee));
    }

//    @Override
//    public EmployeeResponseDTO updateEmployeeById(Long id, EmployeeRequestDTO requestDTO) {
//        log.info("Entering inside udpateEmployee");
//        if(id==null || id<=0){
//            throw new IllegalArgumentException("Invalid Employee Id");
//        }
//        Optional<Employee> existingEmployee = employeeRepository.findByEmpEmailOrEmpCode(requestDTO.getEmpEmail(),requestDTO.getEmpCode());
//        if(existingEmployee.isPresent()){
//            if(existingEmployee.get().getId() != requestDTO.getId()){
//                throw new BadRequestException("email or code already exist");
//            }
//        }
//        Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found with ID "+id));
//
//        employeeMapper.updateEntity(requestDTO ,employee);
////
////        return employeeMapper.toDTO(employeeRepository.save(employee));
//
////        if (requestDTO.getSkills() != null) {
////            List<Skills> updatedSkills = new ArrayList<>();
////
////            List<Long> existingIds = requestDTO.getSkills().stream()
////                    .map(SkillsRequestDTO::getId)
////                    .filter(Objects::nonNull)
////                    .toList();
////
////            if (!existingIds.isEmpty()) {
////                updatedSkills.addAll(skillRepository.findAllById(existingIds));
////            }
////
////            List<Skills> newSkills = requestDTO.getSkills().stream()
////                    .filter(s -> s.getId() == null)
////                    .map(skillsMapper::toEntity)  // or skillsMapper.toEntity()
////                    .toList();
////
////            if (!newSkills.isEmpty()) {
////                updatedSkills.addAll(skillRepository.saveAll(newSkills));
////            }
////            employee.setSkills(updatedSkills);
////        }
//
//        employeeRepository.save(employee);
//        return employeeMapper.toDTO(employee);
//    }

    @Override
    public void deleteEmployee(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid employee id");
        }
        employeeRepository.deleteById(id);

    }
}
