package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "department", collectionRelation = "departments")
public class DepartmentDto extends RepresentationModel<DepartmentDto> {
    private final Integer id;
    private final int number;
    private final Integer drugstoreId;
}
