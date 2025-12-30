package net.irq3.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OnlineController {

    @GetMapping("online")
    public String isOnline(){
        return "Online!!!";
    }
}
