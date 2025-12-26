package net.irq3.blog.repositories;

import net.irq3.blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> getPostById(Long id);

}
