package net.irq3.blog.controllers;

import jakarta.validation.Valid;
import net.irq3.blog.models.Post;
import net.irq3.blog.models.dto.post.PostCreateDTO;
import net.irq3.blog.models.dto.post.PostCreatedDTO;
import net.irq3.blog.services.PostService;
import net.irq3.blog.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posts/")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("create")
    public ResponseEntity<Result<PostCreatedDTO, String>> createPost(@RequestBody @Valid PostCreateDTO postCreateDTO){
        Result<PostCreatedDTO,String> result = postService.createPost(postCreateDTO);
        return ResponseEntity.status(result.status()).body(result);
    }
    @GetMapping("get")
    public ResponseEntity<Result<Post,String>> getPost(@RequestParam("id") Long id){
        Result<Post,String> result = postService.getPost(id);
        return ResponseEntity.status(result.status()).body(result);
    }

    @DeleteMapping("remove")
    public ResponseEntity<Result<String,String>> removePost(@RequestParam("id") Long id){
        Result<String ,String> result = postService.deletePost(id);
        return ResponseEntity.status(result.status()).body(result);
    }

    @GetMapping("work")
    public String working(){
        return "Calm down, everything works";
    }
}
