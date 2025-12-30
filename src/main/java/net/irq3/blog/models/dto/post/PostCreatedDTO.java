package net.irq3.blog.models.dto.post;

import java.util.Date;

public record PostCreatedDTO(Long id, String title, String description, Date dateCreated) {
}
