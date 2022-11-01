package com.rbvgt.lab5.jpa.service;

import com.rbvgt.lab5.jpa.model.Author;
import java.util.List;

public interface AuthorService extends GeneralService<Author, Integer>{
    List<Author> findAuthorByName(String name);
}
