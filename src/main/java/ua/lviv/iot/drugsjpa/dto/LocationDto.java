package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "location", collectionRelation = "locations")
public class LocationDto extends RepresentationModel<LocationDto> {
    private final Integer id;
    private final String street;
    private final Integer departmentId;
    private final Integer cityId;
}
