package net.irq3.blog.controllers;

import net.irq3.blog.utils.EasyUser;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class LoginTestController {

    private final EasyUser easyUser;

    public LoginTestController(EasyUser easyUser) {
        this.easyUser = easyUser;
    }

    @GetMapping("is_logged")
    public Object test(Authentication authentication){
        //return authentication;
       return "You re logged in, Welcome "+easyUser.geLoggedtUser().map(u-> "Welcome "+u.getName()+" !").orElse("You re not logged in :/");
    }
}
