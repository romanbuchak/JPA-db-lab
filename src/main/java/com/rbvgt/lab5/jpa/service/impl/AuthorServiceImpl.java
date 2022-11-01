package com.rbvgt.lab5.jpa.service.impl;

import com.rbvgt.lab5.jpa.exception.AlbumOfSongNotFoundException;
import com.rbvgt.lab5.jpa.model.Author;
import com.rbvgt.lab5.jpa.repository.AuthorRepository;
import com.rbvgt.lab5.jpa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AlbumOfSongNotFoundException(id));
    }

    @Transactional
    public Author create(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Transactional
    public void update(Integer id, Author uAuthor) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AlbumOfSongNotFoundException(id));
        //update
        author.setId(uAuthor.getId());
        author.setName(uAuthor.getName());
        author.setSurname(uAuthor.getSurname());
        author.setGender(uAuthor.getGender());
        author.setEmail(uAuthor.getEmail());


        authorRepository.save(uAuthor);
    }

    @Transactional
    public void delete(Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AlbumOfSongNotFoundException(id));
        authorRepository.delete(author);
    }
}
