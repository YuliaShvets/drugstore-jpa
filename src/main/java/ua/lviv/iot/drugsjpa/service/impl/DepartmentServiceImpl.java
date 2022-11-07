package ua.lviv.iot.drugsjpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ua.lviv.iot.drugsjpa.domain.City;
import ua.lviv.iot.drugsjpa.domain.Department;
import ua.lviv.iot.drugsjpa.repository.CityRepository;
import ua.lviv.iot.drugsjpa.repository.DepartmentRepository;
import ua.lviv.iot.drugsjpa.service.DepartmentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getById(Integer id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department create(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Transactional
    public Department update(Integer id, Department department) {
        Department newDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        //update
        newDepartment.setNumber(department.getNumber());
        newDepartment.setDrugstoreId(department.getDrugstoreId());
        departmentRepository.save(newDepartment);
        return newDepartment;
    }

    @Transactional
    public void delete(Integer id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        departmentRepository.delete(department);
    }

}
