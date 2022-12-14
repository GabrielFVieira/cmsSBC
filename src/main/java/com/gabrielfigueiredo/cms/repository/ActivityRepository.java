package com.gabrielfigueiredo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielfigueiredo.cms.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
