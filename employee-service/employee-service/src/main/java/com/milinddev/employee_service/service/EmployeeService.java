package com.milinddev.employee_service.service;

import com.milinddev.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long EmployeeId);
}
