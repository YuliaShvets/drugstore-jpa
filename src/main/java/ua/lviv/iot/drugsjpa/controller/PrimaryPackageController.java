package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.PrimaryPackage;
import ua.lviv.iot.drugsjpa.dto.PrimaryPackageDto;
import ua.lviv.iot.drugsjpa.dto.assembler.PrimaryPackageDtoAssembler;
import ua.lviv.iot.drugsjpa.service.PrimaryPackageService;

import java.util.List;

@RestController
@RequestMapping("/packaging")

public class PrimaryPackageController {
    @Autowired
    private PrimaryPackageService primaryPackageService;

    @Autowired
    private PrimaryPackageDtoAssembler primaryPackageDtoAssembler;

    @GetMapping
    public CollectionModel<PrimaryPackageDto> getAll() {
        List<PrimaryPackage> primaryPackages = primaryPackageService.getAll();
        return primaryPackageDtoAssembler.toCollectionModel(primaryPackages);
    }

    @GetMapping("/{id}")
    public PrimaryPackageDto getbyId(@PathVariable Integer id) {
        PrimaryPackage primaryPackage = primaryPackageService.getById(id);
        return primaryPackageDtoAssembler.toModel(primaryPackage);
    }

    @PostMapping
    public PrimaryPackageDto create(@RequestBody PrimaryPackage entity) {
        PrimaryPackage primaryPackage = primaryPackageService.create(entity);
        return primaryPackageDtoAssembler.toModel(primaryPackage);
    }

    @PutMapping("/{id}")
    public PrimaryPackageDto update(@PathVariable Integer id, @RequestBody PrimaryPackage entity) {
        PrimaryPackage primaryPackage = primaryPackageService.update(id, entity);
        return primaryPackageDtoAssembler.toModel(primaryPackage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        primaryPackageService.delete(id);
    }
}
