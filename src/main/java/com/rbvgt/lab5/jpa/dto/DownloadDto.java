package com.rbvgt.lab5.jpa.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@Relation(itemRelation = "download", collectionRelation = "downloads")
public class DownloadDto extends RepresentationModel<DownloadDto> {
    private final Integer id;
    private final String songId;
    private final Float price;
    private final Integer quantity;
}
