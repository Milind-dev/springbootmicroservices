package com.milinddev.employee_service.service.impl;

import com.milinddev.employee_service.dto.ApiResponseDto;
import com.milinddev.employee_service.dto.DepartmentDto;
import com.milinddev.employee_service.dto.EmployeeDto;
import com.milinddev.employee_service.entity.Employee;
import com.milinddev.employee_service.repository.EmployeeRepository;
import com.milinddev.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
     Employee saveEmployee = employeeRepository.save(employee);
     EmployeeDto saveEmployeeDto = new EmployeeDto(
             saveEmployee.getId(),
             saveEmployee.getFirstname(),
             saveEmployee.getLastname(),
             saveEmployee.getEmail(),
             saveEmployee.getDepartmentCode()
             );

        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = new EmployeeDto(
          employee.getId(),
          employee.getFirstname(),
          employee.getLastname(),
          employee.getEmail(),
          employee.getDepartmentCode()
        );

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

}
