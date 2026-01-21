package net.irq3.blog.controllers;

import net.irq3.blog.utils.EasyUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasRole('USER')")
public class HelloController {

    private final EasyUser easyUser;

    public HelloController(EasyUser easyUser) {
        this.easyUser = easyUser;
    }

    @GetMapping("/hello")
    public String hello(){
       var name= easyUser.geLoggedtUser().orElse(null).getName();
       return "Hello "+name;
    }
}
