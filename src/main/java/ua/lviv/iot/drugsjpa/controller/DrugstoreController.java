package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Drugstore;
import ua.lviv.iot.drugsjpa.dto.DrugstoreDto;
import ua.lviv.iot.drugsjpa.dto.assembler.DrugstoreDtoAssembler;
import ua.lviv.iot.drugsjpa.service.DrugstoreService;

import java.util.List;

@RestController
@RequestMapping("/drugstore")

public class DrugstoreController {
    @Autowired
    private DrugstoreService drugstoreService;

    @Autowired
    private DrugstoreDtoAssembler drugstoreDtoAssembler;

    @GetMapping
    public CollectionModel<DrugstoreDto> getAll() {
        List<Drugstore> drugstores = drugstoreService.getAll();
        return drugstoreDtoAssembler.toCollectionModel(drugstores);
    }

    @GetMapping("/{id}")
    public DrugstoreDto getbyId(@PathVariable Integer id) {
        Drugstore drugstore = drugstoreService.getById(id);
        return drugstoreDtoAssembler.toModel(drugstore);
    }

    @PostMapping
    public DrugstoreDto create(@RequestBody Drugstore entity) {
        Drugstore drugstore = drugstoreService.create(entity);
        return drugstoreDtoAssembler.toModel(drugstore);
    }

    @PostMapping("/procedure/{name}")
    public void createTenDrugstores(@PathVariable String name){
        drugstoreService.createTenDrugstores(name);
    }

    @PutMapping("/{id}")
    public DrugstoreDto update(@PathVariable Integer id, @RequestBody Drugstore entity) {
        Drugstore drugstore = drugstoreService.update(id, entity);
        return drugstoreDtoAssembler.toModel(drugstore);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        drugstoreService.delete(id);
    }
}
