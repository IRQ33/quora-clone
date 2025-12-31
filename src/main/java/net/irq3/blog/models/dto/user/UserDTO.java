package net.irq3.blog.models.dto.user;

import java.time.LocalDateTime;

public record UserDTO(Long id, String name, String urlImage,LocalDateTime dateCreated) {
}
