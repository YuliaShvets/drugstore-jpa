package ua.lviv.iot.drugsjpa.dto;


import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "city", collectionRelation = "cities")
public class CityDto extends RepresentationModel<CityDto> {
    private final Integer id;
    private final String name;
    private final String countryName;
}
