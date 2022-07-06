package com.waltermilcoff.moviesfest.repository;

import com.waltermilcoff.moviesfest.domain.Category;
import com.waltermilcoff.moviesfest.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}