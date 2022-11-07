package ua.lviv.iot.drugsjpa.dto.assembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.CategoryOfDrugController;
import ua.lviv.iot.drugsjpa.domain.CategoryOfDrug;
import ua.lviv.iot.drugsjpa.dto.CategoryOfDrugDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CategoryOfDrugDtoAssembler implements RepresentationModelAssembler<CategoryOfDrug, CategoryOfDrugDto> {

    @Override
    public CategoryOfDrugDto toModel(CategoryOfDrug entity) {
        CategoryOfDrugDto categoryOfDrugDto = CategoryOfDrugDto.builder()
                .id(entity.getId())
                .requiredPrescription(entity.isRequiredPrescription())
                .type(entity.getType())
                .drugId(entity.getDrugId().getId())
                .build();
        Link link = linkTo(methodOn(CategoryOfDrugController.class).getbyId(categoryOfDrugDto.getId())).withSelfRel();
        categoryOfDrugDto.add(link);
        return categoryOfDrugDto;
    }

    @Override
    public CollectionModel<CategoryOfDrugDto> toCollectionModel(Iterable<? extends CategoryOfDrug> entities) {
        CollectionModel<CategoryOfDrugDto> categoryOfDrugDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(CategoryOfDrugController.class).getAll()).withSelfRel();
        categoryOfDrugDtos.add(links);
        return categoryOfDrugDtos;
    }
}
