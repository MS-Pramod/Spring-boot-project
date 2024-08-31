package com.dailycodebuffer.springboot.tutorial.controller;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/getDepartment/{id}")
    public Optional<Department> getDepartment(@PathVariable Long id){
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
