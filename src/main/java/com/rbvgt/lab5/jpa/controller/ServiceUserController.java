package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.ServiceUserDto;
import com.rbvgt.lab5.jpa.dto.assembler.ServiceUserDtoAssembler;
import com.rbvgt.lab5.jpa.model.ServiceUser;
import com.rbvgt.lab5.jpa.service.ServiceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/serviceUser")
public class ServiceUserController {
    @Autowired
    private ServiceUserService serviceUserService;
    @Autowired
    public ServiceUserDtoAssembler serviceUserDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<ServiceUserDto>> getAll() {
        List<ServiceUser> serviceUsers = serviceUserService.findAll();
        CollectionModel<ServiceUserDto> serviceUserDtos = serviceUserDtoAssembler.toCollectionModel(serviceUsers);
        return new ResponseEntity<>(serviceUserDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ServiceUserDto> getById(@PathVariable Integer id) {
        ServiceUser serviceUser= serviceUserService.findById(id);
        ServiceUserDto serviceUserDto = serviceUserDtoAssembler.toModel(serviceUser);
        return new ResponseEntity<>(serviceUserDto, HttpStatus.OK);
    }

    @GetMapping(value = "/nameOfProfile/{nameOfProfile}")
    public ResponseEntity<CollectionModel<ServiceUserDto>> getServiceUserByNameOfProfile(@PathVariable String nameOfProfile) {
        List<ServiceUser> serviceUser = serviceUserService.findServiceUserByNameOfProfile(nameOfProfile);
        CollectionModel<ServiceUserDto> serviceUserDtos = serviceUserDtoAssembler.toCollectionModel(serviceUser);
        return new ResponseEntity<>(serviceUserDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ServiceUserDto> create(@RequestBody ServiceUser serviceUser) {
        ServiceUser newServiceUser = serviceUserService.create(serviceUser);
        ServiceUserDto serviceUserDto = serviceUserDtoAssembler.toModel(newServiceUser);
        return new ResponseEntity<>(serviceUserDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody ServiceUser uServiceUser, @PathVariable Integer id) {
        serviceUserService.update(id, uServiceUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        serviceUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
