package com.milinddev.employee_service.service;

import com.milinddev.employee_service.dto.ApiResponseDto;
import com.milinddev.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long EmployeeId);
}
