package com.dailycodebuffer.springboot.tutorial.service;

import com.dailycodebuffer.springboot.tutorial.entity.Department;
import com.dailycodebuffer.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements   DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> getAllDepartments() {
       return  departmentRepository.findAll();
    }

    @Override
    public void deleteDepartmentByid(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
         Department department1 =departmentRepository.findById(id).get();
         if(department.getDepartmentName() !=null || department.getDepartmentAddress() !=null ||department.getDepartmentCode() != null){
             department1.setDepartmentAddress(department.getDepartmentAddress());
             department1.setDepartmentCode(department.getDepartmentCode());
             department1.setDepartmentName(department.getDepartmentName());

         }
        return departmentRepository.save(department1);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);

    }
}
