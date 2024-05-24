package org.example.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);
    boolean existsByUserName(String username);
    boolean existsByUserEmail(String email);

    @Query("select u from User u where u.userEmail = :userEmail and u.userPassword = :password")
    User findByUserEmailAndUserPassword(String userEmail, String password);
}
