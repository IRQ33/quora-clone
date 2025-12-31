package net.irq3.blog.servicesImpl;

import jakarta.validation.Valid;
import net.irq3.blog.mappers.UserMapper;
import net.irq3.blog.models.Permissions;
import net.irq3.blog.models.User;
import net.irq3.blog.models.dto.post.PostChangeDTO;
import net.irq3.blog.models.dto.user.UserCreateDTO;
import net.irq3.blog.models.dto.user.UserCreatedDTO;
import net.irq3.blog.models.dto.user.UserDTO;
import net.irq3.blog.repositories.UserRepository;
import net.irq3.blog.services.UserService;
import net.irq3.blog.utils.Result;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override public Result<UserCreatedDTO, String> createUser(UserCreateDTO createDTO) {
        var user = new User();
        user.setEmail(createDTO.getEmail());
        user.setPassword(passwordEncoder.encode(createDTO.getPassword()));
        user.setEmail(createDTO.getEmail());
        user.setName(createDTO.getUserName());
        user.setDateCreated(LocalDateTime.now());
        user.setPermissions(List.of(Permissions.USER));
        userRepository.save(user);
        return Result.resultOk(userMapper.toUserCreateDTO(user));
    }

    @Override public Result<UserDTO, String> getUser(Long id) {
        var user = getUserInternal(id);
        return user.isOk()? Result.resultOk(userMapper.toUserDTO(user.o())): Result.resultError(user.e());
    }

    @Override public Result<User, String> getUserInternal(Long id) {
        var user = userRepository.getUserById(id);
        return user.<Result<User, String>>map(Result::resultOk).orElseGet(() -> Result.resultError("There is no user with this name"));
    }


    @Override public Result<String, String> deleteUser(Long id) {
        var user = getUserInternal(id);
        if(user.isOk()){
            userRepository.delete(user.o());
            return Result.resultOk("Deleted user with "+user.o().getId());
        }
        return Result.resultError(user.e());
    }

    @Override public Result<String, String> changeUser(PostChangeDTO change) {
        return null;
    }
}
