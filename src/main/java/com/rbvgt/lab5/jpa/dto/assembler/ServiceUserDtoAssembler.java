package com.rbvgt.lab5.jpa.dto.assembler;

import com.rbvgt.lab5.jpa.controller.ServiceUserController;
import com.rbvgt.lab5.jpa.dto.ServiceUserDto;
import com.rbvgt.lab5.jpa.model.ServiceUser;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ServiceUserDtoAssembler implements RepresentationModelAssembler<ServiceUser, ServiceUserDto> {
    @Override
    public ServiceUserDto toModel(ServiceUser entity) {
        ServiceUserDto serviceUserDto = ServiceUserDto.builder()
                .id(entity.getId())
                .nameOfProfile(entity.getNameOfProfile())
                .build();
        Link selfLink = linkTo(methodOn(ServiceUserController.class).getById(serviceUserDto.getId())).withSelfRel();
        serviceUserDto.add(selfLink);
        return serviceUserDto;
    }

    @Override
    public CollectionModel<ServiceUserDto> toCollectionModel(Iterable<? extends ServiceUser> entities) {
        CollectionModel<ServiceUserDto> serviceUserDto = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ServiceUserController.class).getAll()).withSelfRel();
        serviceUserDto.add(selfLink);
        return serviceUserDto;
    }

    public CollectionModel<ServiceUserDto> toCollectionModel(Iterable<? extends ServiceUser> entities, Link link) {
        CollectionModel<ServiceUserDto> serviceUserDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        serviceUserDtos.add(link);
        return serviceUserDtos;
    }
}
