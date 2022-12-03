package ua.lviv.iot.drugsjpa.dto;


import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "category_of_drug", collectionRelation = "category_of_drugs")
public class CategoryOfDrugDto extends RepresentationModel<CategoryOfDrugDto> {
    private final Integer id;
    private final boolean requiredPrescription;
    private final String type;
    private final Integer drugId;

}
