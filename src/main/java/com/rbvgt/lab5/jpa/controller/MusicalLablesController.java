package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.MusicalLablesDto;
import com.rbvgt.lab5.jpa.dto.assembler.MusicalLablesDtoAssembler;
import com.rbvgt.lab5.jpa.model.MusicalLables;
import com.rbvgt.lab5.jpa.service.MusicalLablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/musicalLables")
public class MusicalLablesController {
    @Autowired
    private MusicalLablesService musicalLablesService;
    @Autowired
    public MusicalLablesDtoAssembler musicalLablesDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<MusicalLablesDto>> getAll() {
        List<MusicalLables> musicalLabless = musicalLablesService.findAll();
        CollectionModel<MusicalLablesDto> musicalLablesDtos = musicalLablesDtoAssembler.toCollectionModel(musicalLabless);
        return new ResponseEntity<>(musicalLablesDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MusicalLablesDto> getById(@PathVariable Integer id) {
        MusicalLables musicalLables= musicalLablesService.findById(id);
        MusicalLablesDto musicalLablesDto = musicalLablesDtoAssembler.toModel(musicalLables);
        return new ResponseEntity<>(musicalLablesDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<MusicalLablesDto> create(@RequestBody MusicalLables musicalLables) {
        MusicalLables newMusicalLables = musicalLablesService.create(musicalLables);
        MusicalLablesDto musicalLablesDto = musicalLablesDtoAssembler.toModel(newMusicalLables);
        return new ResponseEntity<>(musicalLablesDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody MusicalLables uMusicalLables, @PathVariable Integer id) {
        musicalLablesService.update(id, uMusicalLables);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        musicalLablesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
