package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "genre", collectionRelation = "genres")
public class GenreDto extends RepresentationModel<GenreDto> {
    private final Integer id;
    private final String type;
}
