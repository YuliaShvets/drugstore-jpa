package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "composition_of_drug", collectionRelation = "composition_of_drugs")
public class CompositionOfDrugDto extends RepresentationModel<CategoryOfDrugDto> {
    private final Integer id;
    private final String activeIngredients;
    private final Integer drugId;
}
