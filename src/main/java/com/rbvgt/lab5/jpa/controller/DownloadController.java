package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.dto.DownloadDto;
import com.rbvgt.lab5.jpa.dto.assembler.DownloadDtoAssembler;
import com.rbvgt.lab5.jpa.model.Download;
import com.rbvgt.lab5.jpa.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/download")
public class DownloadController {
    @Autowired
    private DownloadService downloadService;
    @Autowired
    public DownloadDtoAssembler downloadDtoAssembler;

    @GetMapping(value = "/getAll")
    public ResponseEntity<CollectionModel<DownloadDto>> getAll() {
        List<Download> downloads = downloadService.findAll();
        CollectionModel<DownloadDto> downloadDtos = downloadDtoAssembler.toCollectionModel(downloads);
        return new ResponseEntity<>(downloadDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DownloadDto> getById(@PathVariable Integer id) {
        Download download= downloadService.findById(id);
        DownloadDto authorDto = downloadDtoAssembler.toModel(download);
        return new ResponseEntity<>(authorDto, HttpStatus.OK);
    }

    @GetMapping(value = "/average_price")
    public ResponseEntity<Integer> getAveragePrice() {
        Integer avgPrice = downloadService.getAveragePrice();
        return new ResponseEntity<>(avgPrice, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DownloadDto> create(@RequestBody Download download) {
        Download newDownload = downloadService.create(download);
        DownloadDto downloadDto = downloadDtoAssembler.toModel(newDownload);
        return new ResponseEntity<>(downloadDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody Download uDownload, @PathVariable Integer id) {
        downloadService.update(id, uDownload);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        downloadService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
