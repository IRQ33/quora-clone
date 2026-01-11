package net.irq3.blog.models.dto.post;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true) @Data
@NoArgsConstructor
public class PostReplyDTO extends PostCreateDTO{
    Long id;
}
