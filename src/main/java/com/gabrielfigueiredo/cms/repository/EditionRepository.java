package com.gabrielfigueiredo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielfigueiredo.cms.model.Edition;

public interface EditionRepository extends JpaRepository<Edition, Integer> {
}
