package net.irq3.blog.models.dto;

import java.util.Date;

public record PostCreatedDTO(Long id, String title, String description, Date createdAt) {
}
