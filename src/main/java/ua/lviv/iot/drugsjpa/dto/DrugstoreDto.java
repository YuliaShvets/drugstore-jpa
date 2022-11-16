package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "drugstore", collectionRelation = "drugstores")
public class DrugstoreDto extends RepresentationModel<DrugstoreDto> {
    private final Integer id;
    private final String name;
}
