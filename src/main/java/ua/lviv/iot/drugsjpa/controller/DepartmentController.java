package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Department;
import ua.lviv.iot.drugsjpa.dto.DepartmentDto;
import ua.lviv.iot.drugsjpa.dto.assembler.DepartmentDtoAssembler;
import ua.lviv.iot.drugsjpa.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/department")

public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentDtoAssembler departmentDtoAssembler;

    @GetMapping
    public CollectionModel<DepartmentDto> getAll() {
        List<Department> departments = departmentService.getAll();
        return departmentDtoAssembler.toCollectionModel(departments);
    }

    @GetMapping("/{id}")
    public DepartmentDto getbyId(@PathVariable Integer id) {
        Department department = departmentService.getById(id);
        return departmentDtoAssembler.toModel(department);
    }

    @PostMapping
    public DepartmentDto create(@RequestBody Department entity) {
        Department department = departmentService.create(entity);
        return departmentDtoAssembler.toModel(department);
    }

    @PutMapping("/{id}")
    public DepartmentDto update(@PathVariable Integer id, @RequestBody Department entity) {
        Department department = departmentService.update(id, entity);
        return departmentDtoAssembler.toModel(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        departmentService.delete(id);
    }
}
