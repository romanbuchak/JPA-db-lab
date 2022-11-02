package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "albumOfSong", collectionRelation = "albumOfSongs")
public class AlbumOfSongDto extends RepresentationModel<AlbumOfSongDto> {
    private final Integer id;
    private final Integer quantity;
    private final String name;
    private final Integer songId;
}
