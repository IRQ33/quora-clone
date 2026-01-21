package net.irq3.blog.utils;

import net.irq3.blog.models.User;
import net.irq3.blog.models.dto.user.UserAuthCreateDTO;
import net.irq3.blog.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 *  Class works only for spring boot auth and google oauth2
 */
@Service
public class EasyUser {


    private final UserRepository userRepository;

    public EasyUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> geLoggedtUser(){
        var user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";
        if(user instanceof UserDetails){
            email = ((UserDetails) user).getUsername();
        } else if (user instanceof OAuth2User) {
            email = ((OAuth2User) user).getAttribute("email");
            if(email==null){
               email = ((OAuth2User) user).getAttribute("login");
            }
        }
        return userRepository.getUserByEmail(email);
    }
    public UserAuthCreateDTO getAuth2UserGoogle(Authentication authentication){
        UserAuthCreateDTO usr = new UserAuthCreateDTO();
        if(authentication.getPrincipal() instanceof OAuth2User user){
            usr.setEmail(user.getAttribute("email"));
            usr.setName(user.getAttribute("given_name"));
        }else {
            return null;
        }
        return usr;
    }
}
