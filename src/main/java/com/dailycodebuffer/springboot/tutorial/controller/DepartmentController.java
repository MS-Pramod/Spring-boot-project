package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private Logger logger= LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department){
        logger.info("saveDepartment controller"+department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.getDepartment(id);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/deleteDepartment")
    public String deleteDepartmentByid(@RequestParam(name = "id") Long id){
        departmentService.deleteDepartmentByid(id);
        return "deleted successfully";
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/getDepartmentByName/{departmentName}")
    public Department getDepartmentByName( @PathVariable String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
