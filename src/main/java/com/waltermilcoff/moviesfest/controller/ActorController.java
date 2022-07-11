package com.waltermilcoff.moviesfest.controller;

import com.waltermilcoff.moviesfest.domain.CastMember;
import com.waltermilcoff.moviesfest.repository.CastMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    private final CastMemberRepository actorRepository;


    @Autowired
    public ActorController(CastMemberRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @PostMapping("/actor")
    public CastMember createActor(@RequestBody CastMember castMember){
        return actorRepository.save(castMember);

    }
}
