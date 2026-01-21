package net.irq3.blog.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.irq3.blog.models.Permissions;
import net.irq3.blog.models.User;
import net.irq3.blog.repositories.UserRepository;
import net.irq3.blog.utils.EasyUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AutoRegisterHandler implements AuthenticationSuccessHandler {

    private final EasyUser easyUser;
    private final UserRepository userRepository;

    public AutoRegisterHandler(EasyUser easyUser, UserRepository userRepository) {
        this.easyUser = easyUser;
        this.userRepository = userRepository;
    }

    @Override public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var usr = easyUser.getAuth2UserGoogle(authentication);
        if(usr==null){
            response.sendRedirect("/hello");
            return; // it means its not from google
        }
        var unique = userRepository.getUserByEmail(usr.getEmail());
        if(unique.isPresent()){
            response.sendRedirect("/hello");
            return;
        }

        User user = new User();
        user.setName(usr.getName());
        user.setEmail(usr.getEmail());
        user.setPermissions(List.of(Permissions.USER));
        user.setDateCreated(LocalDateTime.now());
        userRepository.save(user);
        response.sendRedirect("/hello");
    }
}
