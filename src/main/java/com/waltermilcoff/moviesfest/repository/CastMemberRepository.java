package com.waltermilcoff.moviesfest.repository;

import com.waltermilcoff.moviesfest.domain.CastMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastMemberRepository extends JpaRepository<CastMember, Long> {
}
