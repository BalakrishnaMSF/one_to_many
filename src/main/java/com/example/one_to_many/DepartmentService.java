package com.example.one_to_many;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Employee createEmployee(Long departmentId, Employee employee) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new EntityNotFoundException("Department not found"));

        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeesByDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new EntityNotFoundException("Department not found"));

        return department.getEmployees();
    }
}

