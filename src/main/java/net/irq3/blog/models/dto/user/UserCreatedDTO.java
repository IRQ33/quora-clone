package net.irq3.blog.models.dto.user;

import java.time.LocalDateTime;

public record UserCreatedDTO(Long id, String name, LocalDateTime dateCreated) {
}
