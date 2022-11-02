package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "author", collectionRelation = "authors")
public class AuthorDto extends RepresentationModel<AuthorDto> {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String gender;
    private final String email;
    private final Integer songId;
}
