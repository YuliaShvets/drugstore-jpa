package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.Date;

@Builder
@Getter
@Relation(itemRelation = "drug", collectionRelation = "drugs")
public class DrugDto extends RepresentationModel<DrugDto> {
    private final Integer id;
    private final String name;
    private final Date productionDate;
    private final Date expirationDate;
    private final boolean isAvailable;
    private final double priceInDollars;
    private final Integer producerId;
    private final Integer drugstoreId;
}
