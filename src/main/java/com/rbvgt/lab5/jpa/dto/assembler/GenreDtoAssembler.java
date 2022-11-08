package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.DownloadController;
import com.rbvgt.lab5.jpa.controller.GenreController;
import com.rbvgt.lab5.jpa.dto.GenreDto;
import com.rbvgt.lab5.jpa.model.Genre;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GenreDtoAssembler implements RepresentationModelAssembler<Genre, GenreDto> {
    @Override
    public GenreDto toModel(Genre entity) {
        GenreDto genreDto = GenreDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .build();
        Link selfLink = linkTo(methodOn(GenreController.class).getById(genreDto.getId())).withSelfRel();
        genreDto.add(selfLink);
        return genreDto;
    }

    @Override
    public CollectionModel<GenreDto> toCollectionModel(Iterable<? extends Genre> entities) {
        CollectionModel<GenreDto> genreDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DownloadController.class).getAll()).withSelfRel();
        genreDto.add(selfLink);
        return genreDto;
    }

    public CollectionModel<GenreDto> toCollectionModel(Iterable<? extends Genre> entities, Link link) {
        CollectionModel<GenreDto> genreDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        genreDtos.add(link);
        return genreDtos;
    }
}
