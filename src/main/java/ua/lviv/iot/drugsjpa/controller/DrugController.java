package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Drug;
import ua.lviv.iot.drugsjpa.dto.DrugDto;
import ua.lviv.iot.drugsjpa.dto.assembler.DrugDtoAssembler;
import ua.lviv.iot.drugsjpa.service.DrugService;

import java.util.List;

@RestController
@RequestMapping("/drug")

public class DrugController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugDtoAssembler drugDtoAssembler;

    @GetMapping
    public CollectionModel<DrugDto> getAll() {
        List<Drug> drugs = drugService.getAll();
        return drugDtoAssembler.toCollectionModel(drugs);
    }

    @GetMapping("/{id}")
    public DrugDto getbyId(@PathVariable Integer id) {
        Drug drug = drugService.getById(id);
        return drugDtoAssembler.toModel(drug);
    }

    @PostMapping
    public DrugDto create(@RequestBody Drug entity) {
        Drug drug = drugService.create(entity);
        return drugDtoAssembler.toModel(drug);
    }

    @PutMapping("/{id}")
    public DrugDto update(@PathVariable Integer id, @RequestBody Drug entity) {
        Drug drug = drugService.update(id, entity);
        return drugDtoAssembler.toModel(drug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        drugService.delete(id);
    }
}
