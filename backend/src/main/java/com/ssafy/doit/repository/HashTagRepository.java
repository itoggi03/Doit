package com.ssafy.doit.repository;

import com.ssafy.doit.model.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HashTagRepository extends JpaRepository<HashTag, Long> {
    Optional<HashTag> findByName(String name);

//  HashTag cnt 내림차순
    List<HashTag> findAllByOrderByCntDesc();
}
