package com.gabrielfigueiredo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielfigueiredo.cms.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
}
