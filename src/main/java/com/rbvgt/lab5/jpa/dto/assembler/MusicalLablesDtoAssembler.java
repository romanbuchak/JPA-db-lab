package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.MusicalLablesController;
import com.rbvgt.lab5.jpa.dto.AlbumOfSongDto;
import com.rbvgt.lab5.jpa.dto.MusicalLablesDto;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import com.rbvgt.lab5.jpa.model.MusicalLables;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MusicalLablesDtoAssembler implements RepresentationModelAssembler<MusicalLables, MusicalLablesDto> {
    @Override
    public MusicalLablesDto toModel(MusicalLables entity) {
        MusicalLablesDto musicalLablesDto = MusicalLablesDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .isAvard(entity.getIsAvard())
                .build();
        Link selfLink = linkTo(methodOn(MusicalLablesController.class).getById(musicalLablesDto.getId())).withSelfRel();
        musicalLablesDto.add(selfLink);
        return musicalLablesDto;
    }

    @Override
    public CollectionModel<MusicalLablesDto> toCollectionModel(Iterable<? extends MusicalLables> entities) {
        CollectionModel<MusicalLablesDto> musicalLablesDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(MusicalLablesController.class).getAll()).withSelfRel();
        musicalLablesDto.add(selfLink);
        return musicalLablesDto;
    }

    public CollectionModel<MusicalLablesDto> toCollectionModel(Iterable<? extends MusicalLables> entities, Link link) {
        CollectionModel<MusicalLablesDto> musicalLablesDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        musicalLablesDtos.add(link);
        return musicalLablesDtos;
    }
}
