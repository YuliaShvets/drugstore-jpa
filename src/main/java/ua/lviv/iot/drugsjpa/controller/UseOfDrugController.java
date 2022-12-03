package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.UseOfDrug;
import ua.lviv.iot.drugsjpa.dto.UseOfDrugDto;
import ua.lviv.iot.drugsjpa.dto.assembler.UseOfDrugDtoAssembler;
import ua.lviv.iot.drugsjpa.service.UseOfDrugService;

import java.util.List;

@RestController
@RequestMapping("/use")

public class UseOfDrugController {
    @Autowired
    private UseOfDrugService useOfDrugService;

    @Autowired
    private UseOfDrugDtoAssembler useOfDrugDtoAssembler;

    @GetMapping
    public CollectionModel<UseOfDrugDto> getAll() {
        List<UseOfDrug> useOfDrugs = useOfDrugService.getAll();
        return useOfDrugDtoAssembler.toCollectionModel(useOfDrugs);
    }

    @GetMapping("/{id}")
    public UseOfDrugDto getbyId(@PathVariable Integer id) {
        UseOfDrug useOfDrug = useOfDrugService.getById(id);
        return useOfDrugDtoAssembler.toModel(useOfDrug);
    }

    @PostMapping
    public UseOfDrugDto create(@RequestBody UseOfDrug entity) {
        UseOfDrug useOfDrug = useOfDrugService.create(entity);
        return useOfDrugDtoAssembler.toModel(useOfDrug);
    }

    @PutMapping("/{id}")
    public UseOfDrugDto update(@PathVariable Integer id, @RequestBody UseOfDrug entity) {
        UseOfDrug useOfDrug = useOfDrugService.update(id, entity);
        return useOfDrugDtoAssembler.toModel(useOfDrug);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        useOfDrugService.delete(id);
    }
}
