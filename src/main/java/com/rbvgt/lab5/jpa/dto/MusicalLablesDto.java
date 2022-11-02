package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "musicalLables", collectionRelation = "musicalLabless")
public class MusicalLablesDto extends RepresentationModel<MusicalLablesDto> {
    private final Integer id;
    private final String name;
    private final String isAvard;
    private final Integer songId;
}
