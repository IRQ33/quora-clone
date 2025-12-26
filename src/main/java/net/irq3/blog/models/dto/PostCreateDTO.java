package net.irq3.blog.models.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class PostCreateDTO {
    @Size(min = 0,max = 200)
    String title;
    @Size(min = 10, max = 100)
    String description;
    String textArticle;

}
