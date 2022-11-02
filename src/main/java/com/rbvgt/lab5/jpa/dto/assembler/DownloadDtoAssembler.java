package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.DownloadController;
import com.rbvgt.lab5.jpa.dto.AlbumOfSongDto;
import com.rbvgt.lab5.jpa.dto.AuthorDto;
import com.rbvgt.lab5.jpa.dto.DownloadDto;
import com.rbvgt.lab5.jpa.model.AlbumOfSong;
import com.rbvgt.lab5.jpa.model.Author;
import com.rbvgt.lab5.jpa.model.Download;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DownloadDtoAssembler implements RepresentationModelAssembler<Download, DownloadDto> {
    @Override
    public DownloadDto toModel(Download entity) {
        DownloadDto downloadDto = DownloadDto.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .quantity(entity.getQuantity())

                //.songId(entity.getDownload().getId())

                .build();
        Link selfLink = linkTo(methodOn(DownloadController.class).getById(downloadDto.getId())).withSelfRel();
        downloadDto.add(selfLink);
        return downloadDto;
    }

    @Override
    public CollectionModel<DownloadDto> toCollectionModel(Iterable<? extends Download> entities) {
        CollectionModel<DownloadDto> downloadDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DownloadController.class).getAll()).withSelfRel();
        downloadDto.add(selfLink);
        return downloadDto;
    }

    public CollectionModel<DownloadDto> toCollectionModel(Iterable<? extends Download> entities, Link link) {
        CollectionModel<DownloadDto> downloadDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        downloadDtos.add(link);
        return downloadDtos;
    }
}
