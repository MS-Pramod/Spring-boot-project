package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.exception.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartment(Long id) throws DepartmentNotFoundException;

    public List<Department> getAllDepartments();

    public void deleteDepartmentByid(Long id);

    public Department updateDepartment(Long id, Department department);

   public  Department getDepartmentByName(String departmentName);
}
