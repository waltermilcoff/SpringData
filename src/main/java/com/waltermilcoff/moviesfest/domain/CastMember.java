package com.waltermilcoff.moviesfest.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class CastMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private LocalDate birthDate;
    private Integer dni;


    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public CastMember() {
    }

    public CastMember(String name, String lastname, LocalDate birthDate, Integer dni) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.dni = dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CastMember castMember = (CastMember) o;
        return Objects.equals(id, castMember.id) && Objects.equals(name, castMember.name) && Objects.equals(lastname, castMember.lastname) && Objects.equals(birthDate, castMember.birthDate) && Objects.equals(dni, castMember.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, birthDate, dni);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", dni=" + dni +
                '}';
    }
}
