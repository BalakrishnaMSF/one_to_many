package com.example.one_to_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PostMapping("/{departmentId}/employees")
    public Employee createEmployee(@PathVariable Long departmentId, @RequestBody Employee employee) {
        return departmentService.createEmployee(departmentId, employee);
    }

    @GetMapping("/{departmentId}/employees")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable Long departmentId) {
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }
}

