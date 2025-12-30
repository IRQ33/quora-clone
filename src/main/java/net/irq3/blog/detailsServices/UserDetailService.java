package net.irq3.blog.detailsServices;

import net.irq3.blog.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.getUserByEmail(email);

        return user.map(usr-> User.builder().username(usr.getEmail()).password(usr.getPassword())
                .roles("USER").build()).orElseThrow(()->new RuntimeException("No user with this email"));
    }
}
