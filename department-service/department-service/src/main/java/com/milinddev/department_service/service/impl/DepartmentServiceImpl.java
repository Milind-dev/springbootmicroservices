package com.milinddev.department_service.service.impl;

import com.milinddev.department_service.dto.DepartmentDto;
import com.milinddev.department_service.entity.Department;
import com.milinddev.department_service.repository.DepartmentRepository;
import com.milinddev.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert departmentdto to jpa department
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
         Department savedDepartment =  departmentRepository.save(department);
        //convert department jpa to department Dto
         DepartmentDto savedDepartmentDto = new DepartmentDto(
                 department.getId(),
                 department.getDepartmentName(),
                 department.getDepartmentDescription(),
                 department.getDepartmentCode()
         );
         return  savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentcode) {
       Department department = departmentRepository.findByDepartmentCode(departmentcode);
       DepartmentDto departmentDto = new DepartmentDto(
               department.getId(),
               department.getDepartmentName(),
               department.getDepartmentDescription(),
               department.getDepartmentCode()
       );

        return departmentDto;
    }
}
