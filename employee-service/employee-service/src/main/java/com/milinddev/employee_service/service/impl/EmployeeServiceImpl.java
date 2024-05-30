package com.milinddev.employee_service.service.impl;

import com.milinddev.employee_service.dto.EmployeeDto;
import com.milinddev.employee_service.entity.Employee;
import com.milinddev.employee_service.repository.EmployeeRepository;
import com.milinddev.employee_service.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstname(),
                employeeDto.getLastname(),
                employeeDto.getEmail()
        );
     Employee saveEmployee = employeeRepository.save(employee);
     EmployeeDto saveEmployeeDto = new EmployeeDto(
             saveEmployee.getId(),
             saveEmployee.getFirstname(),
             saveEmployee.getLastname(),
             saveEmployee.getEmail()
     );

        return saveEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long EmployeeId) {
        Employee employee = employeeRepository.findById(EmployeeId).get();
        EmployeeDto employeeDto = new EmployeeDto(
          employee.getId(),
          employee.getFirstname(),
          employee.getLastname(),
          employee.getEmail()
        );
        return employeeDto;
    }
}
