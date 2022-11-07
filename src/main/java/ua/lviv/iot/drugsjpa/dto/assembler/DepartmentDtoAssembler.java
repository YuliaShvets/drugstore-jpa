package ua.lviv.iot.drugsjpa.dto.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import ua.lviv.iot.drugsjpa.controller.DepartmentController;
import ua.lviv.iot.drugsjpa.domain.Department;
import ua.lviv.iot.drugsjpa.dto.DepartmentDto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DepartmentDtoAssembler implements RepresentationModelAssembler<Department, DepartmentDto> {
    @Override
    public DepartmentDto toModel(Department entity) {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id(entity.getId())
                .number(entity.getNumber())
                .drugstoreId(entity.getDrugstoreId().getId())
                .build();
        Link link = linkTo(methodOn(DepartmentController.class).getbyId(departmentDto.getId())).withSelfRel();
        departmentDto.add(link);
        return departmentDto;
    }

    @Override
    public CollectionModel<DepartmentDto> toCollectionModel(Iterable<? extends Department> entities) {
        CollectionModel<DepartmentDto> departmentDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link links = linkTo(methodOn(DepartmentController.class).getAll()).withSelfRel();
        departmentDtos.add(links);
        return departmentDtos;
    }
}
