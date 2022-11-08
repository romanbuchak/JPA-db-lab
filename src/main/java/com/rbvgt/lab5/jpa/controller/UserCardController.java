package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.UserCardDto;
import com.rbvgt.lab5.jpa.dto.assembler.UserCardDtoAssembler;
import com.rbvgt.lab5.jpa.model.UserCard;
import com.rbvgt.lab5.jpa.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/userCard")
public class UserCardController {
    @Autowired
    private UserCardService userCardService;
    @Autowired
    private UserCardDtoAssembler userCardDtoAssembler;

    @GetMapping(value = "/get")
    public ResponseEntity<CollectionModel<UserCardDto>> getAllUserCard() {
        List<UserCard> userCards = userCardService.findAll();
        CollectionModel<UserCardDto> userCardDtos = userCardDtoAssembler.toCollectionModel(userCards);
        return new ResponseEntity<>(userCardDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCardDto> getUserCard(@PathVariable Integer id) {
        UserCard userCard = userCardService.findById(id);
        UserCardDto userCardDto = userCardDtoAssembler.toModel(userCard);
        return new ResponseEntity<>(userCardDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCardDto> createUserCard(@RequestBody UserCard userCard) {
        UserCard newUserCard = userCardService.create(userCard);
        UserCardDto userCardDto = userCardDtoAssembler.toModel(newUserCard);
        return new ResponseEntity<>(userCardDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUserCard(@RequestBody UserCard uUserCard, @PathVariable Integer id) {
        userCardService.update(id, uUserCard);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUserCard(@PathVariable Integer id) {
        userCardService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
