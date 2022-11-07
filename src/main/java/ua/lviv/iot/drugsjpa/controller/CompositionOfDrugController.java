package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.CompositionOfDrug;
import ua.lviv.iot.drugsjpa.dto.CompositionOfDrugDto;
import ua.lviv.iot.drugsjpa.dto.assembler.CompositionOfDrugDtoAssembler;
import ua.lviv.iot.drugsjpa.service.CompositionOfDrugService;

import java.util.List;

@RestController
@RequestMapping("/composition")
public class CompositionOfDrugController {
    @Autowired
    private CompositionOfDrugService compositionOfDrugService;
    @Autowired
    private CompositionOfDrugDtoAssembler compositionOfDrugDtoAssembler;

    @GetMapping
    public CollectionModel<CompositionOfDrugDto> getAll() {
        List<CompositionOfDrug> compositionOfDrugs = compositionOfDrugService.getAll();
        return compositionOfDrugDtoAssembler.toCollectionModel(compositionOfDrugs);
    }

    @GetMapping("/{id}")
    public CompositionOfDrugDto getbyId(@PathVariable Integer id) {
        CompositionOfDrug compositionOfDrug = compositionOfDrugService.getById(id);
        return compositionOfDrugDtoAssembler.toModel(compositionOfDrug);
    }

    @PostMapping
    public CompositionOfDrugDto create(@RequestBody CompositionOfDrug entity) {
        CompositionOfDrug compositionOfDrug = compositionOfDrugService.create(entity);
        return compositionOfDrugDtoAssembler.toModel(compositionOfDrug);
    }

    @PutMapping("/{id}")
    public CompositionOfDrugDto update(@PathVariable Integer id, @RequestBody CompositionOfDrug entity) {
        CompositionOfDrug compositionOfDrug = compositionOfDrugService.update(id, entity);
        return compositionOfDrugDtoAssembler.toModel(compositionOfDrug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        compositionOfDrugService.delete(id);
    }
}
