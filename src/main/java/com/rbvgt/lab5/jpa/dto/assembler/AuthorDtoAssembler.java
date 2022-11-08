package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.AuthorController;
import com.rbvgt.lab5.jpa.dto.AuthorDto;
import com.rbvgt.lab5.jpa.model.Author;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AuthorDtoAssembler implements RepresentationModelAssembler<Author, AuthorDto> {
    @Override
    public AuthorDto toModel(Author entity) {
        AuthorDto authorDto = AuthorDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .gender(entity.getGender())
                .email(entity.getEmail())


                .build();
        Link selfLink = linkTo(methodOn(AuthorController.class).getById(authorDto.getId())).withSelfRel();
        authorDto.add(selfLink);
        return authorDto;
    }

    @Override
    public CollectionModel<AuthorDto> toCollectionModel(Iterable<? extends Author> entities) {
        CollectionModel<AuthorDto> authorDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(AuthorController.class).getAll()).withSelfRel();
        authorDto.add(selfLink);
        return authorDto;
    }

    public CollectionModel<AuthorDto> toCollectionModel(Iterable<? extends Author> entities, Link link) {
        CollectionModel<AuthorDto> authorDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        authorDtos.add(link);
        return authorDtos;
    }
}
