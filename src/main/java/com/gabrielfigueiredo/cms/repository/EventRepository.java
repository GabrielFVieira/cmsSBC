package com.gabrielfigueiredo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gabrielfigueiredo.cms.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value= "SELECT e.* FROM evento e WHERE e.caminho = :path LIMIT 1", nativeQuery = true)
    public Event findByPath(@Param("path")String path);
}
