package com.rbvgt.lab5.jpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "download", collectionRelation = "downloads")
public class DownloadDto extends RepresentationModel<DownloadDto> {
    private final Integer id;
    private final Float price;
    private final Integer quantity;
}
