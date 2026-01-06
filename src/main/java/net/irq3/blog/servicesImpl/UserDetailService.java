package net.irq3.blog.servicesImpl;

import net.irq3.blog.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.getUserByEmail(email).orElseThrow();
        var roles = user.getPermissions().stream().map(Enum::name).toArray(String[]::new);

        return User.builder().username(user.getEmail())
                .password(user.getPassword())
                .roles(roles)
                .build();
    }
}
