package com.waltermilcoff.moviesfest.controller;

import com.waltermilcoff.moviesfest.domain.CastMember;
import com.waltermilcoff.moviesfest.domain.Film;
import com.waltermilcoff.moviesfest.repository.CastMemberRepository;
import com.waltermilcoff.moviesfest.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FilmController {

    private final FilmRepository filmRepository;
    private final CastMemberRepository castMemberRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository, CastMemberRepository castMemberRepository) {

        this.filmRepository = filmRepository;
        this.castMemberRepository = castMemberRepository;
    }


    @PostMapping("/film")
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);

   }

   @PostMapping("/fim/{idFilm}/actor")
    public String addActorToMovie(@PathVariable Long idFilm, @RequestBody List<Long> actorIds) {
       Film film = filmRepository.findById(idFilm).orElse(null);
       List<CastMember> actors = actorIds.stream()
               .map(id -> castMemberRepository.findById(id))
               .filter(Optional::isPresent)
               .map(Optional::get)
               .collect(Collectors.toList());
       for (CastMember castMember : actors){
           film.addActor(castMember);
       }
       filmRepository.save(film);
       return "OK";

   }

}
