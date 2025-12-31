package net.irq3.blog.controllers;

import jakarta.validation.Valid;
import net.irq3.blog.models.dto.user.UserCreateDTO;
import net.irq3.blog.models.dto.user.UserCreatedDTO;
import net.irq3.blog.models.dto.user.UserDTO;
import net.irq3.blog.services.UserService;
import net.irq3.blog.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("register")
    public ResponseEntity<Result<UserCreatedDTO,String>> createUser(@RequestBody @Valid UserCreateDTO createDTO){
        var result = userService.createUser(createDTO);
        return ResponseEntity.status(result.status()).body(result);
    }
    @GetMapping("getUser")
    public ResponseEntity<Result<UserDTO, String>> getUser(@RequestParam("id") Long id){
        var result = userService.getUser(id);
        return ResponseEntity.status(result.status()).body(result);
    }

}
