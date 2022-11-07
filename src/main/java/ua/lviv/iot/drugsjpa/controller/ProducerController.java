package ua.lviv.iot.drugsjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.drugsjpa.domain.Producer;
import ua.lviv.iot.drugsjpa.dto.ProducerDto;
import ua.lviv.iot.drugsjpa.dto.assembler.ProducerDtoAssembler;
import ua.lviv.iot.drugsjpa.service.ProducerService;

import java.util.List;

@RestController
@RequestMapping("/producer")

public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @Autowired
    private ProducerDtoAssembler producerDtoAssembler;

    @GetMapping
    public CollectionModel<ProducerDto> getAll() {
        List<Producer> producers = producerService.getAll();
        return producerDtoAssembler.toCollectionModel(producers);
    }

    @GetMapping("/{id}")
    public ProducerDto getbyId(@PathVariable Integer id) {
        Producer producer = producerService.getById(id);
        return producerDtoAssembler.toModel(producer);
    }

    @PostMapping
    public ProducerDto create(@RequestBody Producer entity) {
        Producer producer = producerService.create(entity);
        return producerDtoAssembler.toModel(producer);
    }

    @PutMapping("/{id}")
    public ProducerDto update(@PathVariable Integer id, @RequestBody Producer entity) {
        Producer producer = producerService.update(id, entity);
        return producerDtoAssembler.toModel(producer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        producerService.delete(id);
    }
}
