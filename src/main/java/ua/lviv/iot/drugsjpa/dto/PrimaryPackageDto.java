package ua.lviv.iot.drugsjpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "primary_package", collectionRelation = "primary_packages")
public class PrimaryPackageDto extends RepresentationModel<PrimaryPackageDto> {
    private final Integer id;
    private final String typePackaging;
    private final Integer drugId;
}
