package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.CategoryOfDrug;
import ua.lviv.iot.drugsjpa.dto.CategoryOfDrugDto;
import ua.lviv.iot.drugsjpa.dto.assembler.CategoryOfDrugDtoAssembler;
import ua.lviv.iot.drugsjpa.service.CategoryOfDrugService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryOfDrugController {

    @Autowired
    private CategoryOfDrugService categoryOfDrugService;

    @Autowired
    private CategoryOfDrugDtoAssembler categoryOfDrugDtoAssembler;

    @GetMapping
    public CollectionModel<CategoryOfDrugDto> getAll() {
        List<CategoryOfDrug> categoryOfDrugList = categoryOfDrugService.getAll();
        return categoryOfDrugDtoAssembler.toCollectionModel(categoryOfDrugList);
    }

    @GetMapping("/{id}")
    public CategoryOfDrugDto getbyId(@PathVariable Integer id) {
        CategoryOfDrug categoryOfDrug = categoryOfDrugService.getById(id);
        return categoryOfDrugDtoAssembler.toModel(categoryOfDrug);
    }

    @PostMapping
    public CategoryOfDrugDto create(@RequestBody CategoryOfDrug entity) {
        CategoryOfDrug categoryOfDrug = categoryOfDrugService.create(entity);
        return categoryOfDrugDtoAssembler.toModel(categoryOfDrug);
    }

    @PutMapping("/{id}")
    public CategoryOfDrugDto update(@PathVariable Integer id, @RequestBody CategoryOfDrug entity) {
        CategoryOfDrug categoryOfDrug = categoryOfDrugService.update(id, entity);
        return categoryOfDrugDtoAssembler.toModel(categoryOfDrug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryOfDrugService.delete(id);
    }
}
