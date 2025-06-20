package org.xproce.produitexample.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xproce.produitexample.dao.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
} 