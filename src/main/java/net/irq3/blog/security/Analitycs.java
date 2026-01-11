package net.irq3.blog.security;

import net.irq3.blog.models.User;
import net.irq3.blog.repositories.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Analitycs {

    private final UserRepository userRepository;

    public Analitycs(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent event) {

    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent event) {

        if(event.getException() instanceof BadCredentialsException){
            Authentication auth = event.getAuthentication();

            String email = auth.getName();
            Optional<User> usr = userRepository.getUserByEmail(email);
            if(usr.isEmpty()) return;
            //TODO
            //here send the email :D
        }

    }
}
