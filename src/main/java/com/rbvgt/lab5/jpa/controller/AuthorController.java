package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.AuthorDto;
import com.rbvgt.lab5.jpa.dto.assembler.AuthorDtoAssembler;
import com.rbvgt.lab5.jpa.model.Author;
import com.rbvgt.lab5.jpa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    public AuthorDtoAssembler authorDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<AuthorDto>> getAll() {
        List<Author> authors = authorService.findAll();
        CollectionModel<AuthorDto> authorDtos = authorDtoAssembler.toCollectionModel(authors);
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthorDto> getById(@PathVariable Integer id) {
        Author author= authorService.findById(id);
        AuthorDto authorDto = authorDtoAssembler.toModel(author);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<CollectionModel<AuthorDto>> getAuthorByName(@PathVariable String name) {
        List<Author> author = authorService.findAuthorByName(name);
        CollectionModel<AuthorDto> authorDtos = authorDtoAssembler.toCollectionModel(author);
        return new ResponseEntity<>(authorDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<AuthorDto> create(@RequestBody Author author) {
        Author newAuthor = authorService.create(author);
        AuthorDto authorDto = authorDtoAssembler.toModel(newAuthor);
        return new ResponseEntity<>(authorDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Author uAuthor, @PathVariable Integer id) {
        authorService.update(id, uAuthor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
