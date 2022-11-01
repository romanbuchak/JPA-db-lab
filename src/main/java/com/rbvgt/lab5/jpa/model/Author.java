package com.rbvgt.lab5.jpa.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name", length = 25, nullable = false)
    private String name;
    @Basic
    @Column(name = "surname", length = 25, nullable = false)
    private String surname;
    @Basic
    @Column(name = "gender", length = 30)
    private String gender;
    @Basic
    @Column(name = "email", length = 45)
    private String email;
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(surname, author.surname)  && Objects.equals(gender, author.gender) && Objects.equals(email, author.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, gender, email);
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
