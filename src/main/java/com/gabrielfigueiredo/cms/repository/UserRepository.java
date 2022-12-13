package com.gabrielfigueiredo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gabrielfigueiredo.cms.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
