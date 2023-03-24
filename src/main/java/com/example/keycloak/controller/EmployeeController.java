package com.example.keycloak.controller;

import com.example.keycloak.entity.Employee;
import com.example.keycloak.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/employee")
    @RolesAllowed({"user", "admin"})
    public ResponseEntity<?> save(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }
    @GetMapping("/employee")
    @RolesAllowed("admin")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
