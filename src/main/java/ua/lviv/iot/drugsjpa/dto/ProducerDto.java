package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "producer", collectionRelation = "producers")
public class ProducerDto extends RepresentationModel<ProducerDto> {
    private final Integer id;
    private final String name;
    private final String countryName;
}
