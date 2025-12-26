package net.irq3.blog.mappers;

import net.irq3.blog.models.Post;
import net.irq3.blog.models.dto.PostCreatedDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostCreatedDTO toPostCreatedDTO(Post post);
}
