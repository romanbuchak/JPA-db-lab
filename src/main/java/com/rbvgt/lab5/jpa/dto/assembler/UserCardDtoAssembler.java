package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.UserCardController;
import com.rbvgt.lab5.jpa.dto.UserCardDto;
import com.rbvgt.lab5.jpa.model.UserCard;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserCardDtoAssembler implements RepresentationModelAssembler<UserCard, UserCardDto> {
    @Override
    public UserCardDto toModel(UserCard entity) {
        UserCardDto userCardDto = UserCardDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
        Link selfLink = linkTo(methodOn(UserCardController.class).getUserCard(userCardDto.getId())).withSelfRel();
        userCardDto.add(selfLink);
        return userCardDto;
    }

    @Override
    public CollectionModel<UserCardDto> toCollectionModel(Iterable<? extends UserCard> entities) {
        CollectionModel<UserCardDto> userCardDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserCardController.class).getAllUserCard()).withSelfRel();
        userCardDtos.add(selfLink);
        return userCardDtos;
    }
}
