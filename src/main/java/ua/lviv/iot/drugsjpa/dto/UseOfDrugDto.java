package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "use_of_drug", collectionRelation = "use_of_drugs")
public class UseOfDrugDto extends RepresentationModel<UseOfDrugDto> {
    private final Integer id;
    private final String useType;
    private final Integer drugId;
}
