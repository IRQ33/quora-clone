package net.irq3.blog.services;

import net.irq3.blog.models.User;
import net.irq3.blog.models.dto.post.PostChangeDTO;
import net.irq3.blog.models.dto.user.UserCreateDTO;
import net.irq3.blog.models.dto.user.UserCreatedDTO;
import net.irq3.blog.utils.Result;

public interface UserService {
    Result<UserCreatedDTO, String> createUser(UserCreateDTO createDTO);
    Result<User,String> getUser(Long id);
    Result<String, String> deleteUser(Long id);
    Result<String, String> changeUser(PostChangeDTO change);
}
