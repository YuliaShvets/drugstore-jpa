package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.ProducerController;
import ua.lviv.iot.drugsjpa.domain.Producer;
import ua.lviv.iot.drugsjpa.dto.ProducerDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ProducerDtoAssembler implements RepresentationModelAssembler<Producer, ProducerDto> {

    @Override
    public ProducerDto toModel(Producer entity) {
        ProducerDto producerDto = ProducerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .countryName(entity.getCountryName().getName())
                .build();
        Link link = linkTo(methodOn(ProducerController.class).getbyId(producerDto.getId())).withSelfRel();
        producerDto.add(link);
        return producerDto;
    }

    @Override
    public CollectionModel<ProducerDto> toCollectionModel(Iterable<? extends Producer> entities) {
        CollectionModel<ProducerDto> producerDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(ProducerController.class).getAll()).withSelfRel();
        producerDtos.add(links);
        return producerDtos;
    }
}
