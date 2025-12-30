package net.irq3.blog.models.dto.post;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCreateDTO {
    @Size(min = 0,max = 200)
    String title;
    @Size(min = 10, max = 100)
    String description;
    String textArticle;

}
