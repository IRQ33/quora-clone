package net.irq3.blog.repositories;

import net.irq3.blog.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicsRepository extends JpaRepository<Topic,Long> {
    Optional<Topic> getTopicById(Long id);
    Optional<Topic> getTopicByName(String name);
}
