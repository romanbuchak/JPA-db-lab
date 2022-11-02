package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.AlbumOfSongController;
import com.rbvgt.lab5.jpa.dto.AlbumOfSongDto;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AlbumOfSongDtoAssembler implements RepresentationModelAssembler<AlbumOfSong, AlbumOfSongDto> {
    @Override
    public AlbumOfSongDto toModel(AlbumOfSong entity) {
        AlbumOfSongDto albumOfSongDto = AlbumOfSongDto.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .name(entity.getName())

                .build();
        Link selfLink = linkTo(methodOn(AlbumOfSongController.class).getById(albumOfSongDto.getId())).withSelfRel();
        albumOfSongDto.add(selfLink);
        return albumOfSongDto;
    }

    @Override
    public CollectionModel<AlbumOfSongDto> toCollectionModel(Iterable<? extends AlbumOfSong> entities) {
        CollectionModel<AlbumOfSongDto> albumOfSongDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AlbumOfSongController.class).getAll()).withSelfRel();
        albumOfSongDtos.add(selfLink);
        return albumOfSongDtos;
    }

    public CollectionModel<AlbumOfSongDto> toCollectionModel(Iterable<? extends AlbumOfSong> entities, Link link) {
        CollectionModel<AlbumOfSongDto> albumOfSongDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        albumOfSongDtos.add(link);
        return albumOfSongDtos;
    }
}
