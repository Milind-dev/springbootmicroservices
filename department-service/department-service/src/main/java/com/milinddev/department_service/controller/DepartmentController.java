package com.milinddev.department_service.controller;

import com.milinddev.department_service.dto.DepartmentDto;
import com.milinddev.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @GetMapping("{departmentcode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("departmentcode") String departmentcode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentcode);
        return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
