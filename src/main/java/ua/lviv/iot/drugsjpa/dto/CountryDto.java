package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "country", collectionRelation = "countries")
public class CountryDto extends RepresentationModel<CountryDto> {
    private final String name;
}
