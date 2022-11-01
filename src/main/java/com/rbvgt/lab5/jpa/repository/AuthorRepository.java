package com.rbvgt.lab5.jpa.repository;

import com.rbvgt.lab5.jpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findAuthorByName(String name);
}
