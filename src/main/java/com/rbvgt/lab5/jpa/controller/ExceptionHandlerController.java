package com.rbvgt.lab5.jpa.controller;

import com.rbvgt.lab5.jpa.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(AlbumOfSongNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String albumOfSongNotFoundHandler(AlbumOfSongNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String authorNotFoundHandler(AuthorNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(DownloadNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String downloadNotFoundHandler(DownloadNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(GenreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String genreNotFoundHandler(GenreNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(MusicalLablesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String musicalLablesNotFoundHandler(MusicalLablesNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ServiceUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String serviceUserNotFoundHandler(ServiceUserNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(SongNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String songNotFoundHandler(SongNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(UserCardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userCardNotFoundHandler(UserCardNotFoundException ex) {
        return ex.getMessage();
    }
}