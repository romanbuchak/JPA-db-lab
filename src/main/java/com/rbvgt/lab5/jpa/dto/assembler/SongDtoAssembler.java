package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.SongController;
import com.rbvgt.lab5.jpa.dto.AlbumOfSongDto;
import com.rbvgt.lab5.jpa.dto.SongDto;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import com.rbvgt.lab5.jpa.model.Song;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SongDtoAssembler implements RepresentationModelAssembler<Song, SongDto> {
    @Override
    public SongDto toModel(Song entity) {
        SongDto songDto = SongDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(SongController.class).getById(songDto.getId())).withSelfRel();
        songDto.add(selfLink);
        return songDto;
    }

    @Override
    public CollectionModel<SongDto> toCollectionModel(Iterable<? extends Song> entities) {
        CollectionModel<SongDto> songDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SongController.class).getAll()).withSelfRel();
        songDto.add(selfLink);
        return songDto;
    }

    public CollectionModel<SongDto> toCollectionModel(Iterable<? extends Song> entities, Link link) {
        CollectionModel<SongDto> songDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        songDtos.add(link);
        return songDtos;
    }
}
