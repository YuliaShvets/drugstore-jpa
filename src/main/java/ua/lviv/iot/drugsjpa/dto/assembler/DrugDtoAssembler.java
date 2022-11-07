package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.DrugController;
import ua.lviv.iot.drugsjpa.domain.Drug;
import ua.lviv.iot.drugsjpa.dto.DrugDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DrugDtoAssembler implements RepresentationModelAssembler<Drug, DrugDto> {
    @Override
    public DrugDto toModel(Drug entity) {
        DrugDto drugDto = DrugDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productionDate(entity.getProductionDate())
                .expirationDate(entity.getExpirationDate())
                .isAvailable(entity.isAvailable())
                .priceInDollars(entity.getPriceInDollars())
                .producerId(entity.getProducerId().getId())
                .drugstoreId(entity.getDrugstoreId().getId())
                .build();
        Link link = linkTo(methodOn(DrugController.class).getbyId(drugDto.getId())).withSelfRel();
        drugDto.add(link);
        return drugDto;
    }

    @Override
    public CollectionModel<DrugDto> toCollectionModel(Iterable<? extends Drug> entities) {
        CollectionModel<DrugDto> drugDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(DrugController.class).getAll()).withSelfRel();
        drugDtos.add(links);
        return drugDtos;
    }
}
