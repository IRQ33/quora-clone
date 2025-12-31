package net.irq3.blog.mappers;

import net.irq3.blog.models.User;
import net.irq3.blog.models.dto.user.UserCreatedDTO;
import net.irq3.blog.models.dto.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserCreatedDTO toUserCreateDTO(User user);
    UserDTO toUserDTO(User user);
}
