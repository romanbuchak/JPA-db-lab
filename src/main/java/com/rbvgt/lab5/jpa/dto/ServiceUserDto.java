package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "serviceUser", collectionRelation = "serviceUsers")
public class ServiceUserDto extends RepresentationModel<ServiceUserDto> {
    private final Integer id;
    private final String nameOfProfile;
    private final Integer downloadId;
}
