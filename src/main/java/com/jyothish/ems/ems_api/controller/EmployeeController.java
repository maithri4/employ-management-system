package com.jyothish.ems.ems_api.controller;

import com.jyothish.ems.ems_api.entity.Employee;
import com.jyothish.ems.ems_api.repository.EmployeeRepository;
import com.jyothish.ems.ems_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService service;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(service.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId)
    {
        Employee employee = service.getEmployeeById(empId);
        if(employee!=null)
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        else
            return new ResponseEntity<>(new Employee(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        List<Employee> employeeList = service.getAllEmployees();
        if (employeeList!=null)
            return new ResponseEntity<>(employeeList, HttpStatus.OK);
        else
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long empId)
    {
        service.deleteEmployeeById(empId);
        return new ResponseEntity<>("Employee deleted successfully",
                    HttpStatus.OK);
    }

    @PutMapping("/employee")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
    {
       if(repository.existsById(employee.getId()))
       {
           service.updateProduct(employee);
           return new ResponseEntity<>("Employee "+employee.getFirstName()+" updated successfully", HttpStatus.OK);
       }
       else
           return new ResponseEntity<>("Employee Not Found!", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Employee>> searchEmployeesByKeyword(@PathVariable String keyword)
    {
         return new ResponseEntity<>(service.searchEmployeesByKeyword(keyword), HttpStatus.OK);
    }
}
//@CrossOrigin(origins = "http://localhost:5173/")
