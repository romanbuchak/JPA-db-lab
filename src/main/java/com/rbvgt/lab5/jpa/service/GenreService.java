package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.Genre;
import java.util.List;

public interface GenreService extends GeneralService<Genre, Integer> {
    List<Genre> findGenreByType(String type);
}
