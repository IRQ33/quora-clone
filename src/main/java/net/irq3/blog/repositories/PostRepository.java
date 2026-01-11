package net.irq3.blog.repositories;

import jakarta.validation.constraints.NotNull;
import net.irq3.blog.models.Post;
import net.irq3.blog.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> getPostById(Long id);

//    @Query("")
//    Optional<List<Post>> getPostsByTopic(Topic topic);

}
