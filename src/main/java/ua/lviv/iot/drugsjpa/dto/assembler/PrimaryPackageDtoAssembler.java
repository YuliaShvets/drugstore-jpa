package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.PrimaryPackageController;
import ua.lviv.iot.drugsjpa.domain.PrimaryPackage;
import ua.lviv.iot.drugsjpa.dto.PrimaryPackageDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PrimaryPackageDtoAssembler implements RepresentationModelAssembler<PrimaryPackage, PrimaryPackageDto> {
    @Override
    public PrimaryPackageDto toModel(PrimaryPackage entity) {
        PrimaryPackageDto primaryPackageDto = PrimaryPackageDto.builder()
                .id(entity.getId())
                .typePackaging(entity.getTypePackaging())
                .drugId(entity.getDrugId().getId())
                .build();
        Link link = linkTo(methodOn(PrimaryPackageController.class).getbyId(primaryPackageDto.getId())).withSelfRel();
        primaryPackageDto.add(link);
        return primaryPackageDto;
    }

    @Override
    public CollectionModel<PrimaryPackageDto> toCollectionModel(Iterable<? extends PrimaryPackage> entities) {
        CollectionModel<PrimaryPackageDto> primaryPackageDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(PrimaryPackageController.class).getAll()).withSelfRel();
        primaryPackageDtos.add(links);
        return primaryPackageDtos;
    }
}
