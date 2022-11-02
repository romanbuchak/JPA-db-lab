package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "song", collectionRelation = "songs")
public class SongDto extends RepresentationModel<SongDto> {
    private final Integer id;
    private final String name;
    private final Integer genreId;
}
