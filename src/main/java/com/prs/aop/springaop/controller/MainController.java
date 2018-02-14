package com.prs.aop.springaop.controller;

import com.prs.aop.springaop.dto.EmployeeDTO;
import com.prs.aop.springaop.service.EmployeeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping("/")
    public void test(){
        employeeManager.createEmployee(new EmployeeDTO());
        employeeManager.updateEmployee(new EmployeeDTO());
        employeeManager.getEmployeeById(1);
        employeeManager.getAllEmployee();
        employeeManager.deleteEmployee(1);
    }
}
