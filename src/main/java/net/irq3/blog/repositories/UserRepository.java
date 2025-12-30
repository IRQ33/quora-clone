package net.irq3.blog.repositories;

import net.irq3.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByName(String name);
    Optional<User> getUserByEmail(String email);
    boolean existsByEmail(String email);
}
