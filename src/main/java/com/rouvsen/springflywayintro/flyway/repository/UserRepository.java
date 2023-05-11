package com.rouvsen.springflywayintro.flyway.repository;

import com.rouvsen.springflywayintro.flyway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {
}
