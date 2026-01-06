package net.irq3.blog.controllers;

import net.irq3.blog.utils.EasyUser;
import org.springframework.context.annotation.Profile;
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
    public String test(){

        return "You re logged in, Welcome "+easyUser.getUser().get().getName();
    }
}
