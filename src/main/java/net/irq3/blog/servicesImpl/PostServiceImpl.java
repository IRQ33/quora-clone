package net.irq3.blog.servicesImpl;

import net.irq3.blog.mappers.PostMapper;
import net.irq3.blog.models.Permissions;
import net.irq3.blog.models.Post;
import net.irq3.blog.models.User;
import net.irq3.blog.models.dto.post.PostChangeDTO;
import net.irq3.blog.models.dto.post.PostCreateDTO;
import net.irq3.blog.models.dto.post.PostCreatedDTO;
import net.irq3.blog.repositories.PostRepository;
import net.irq3.blog.repositories.UserRepository;
import net.irq3.blog.services.PostService;
import net.irq3.blog.utils.EasyUser;
import net.irq3.blog.utils.Result;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;
    private final EasyUser easyUser;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper, UserRepository userRepository, EasyUser easyUser) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
        this.userRepository = userRepository;
        this.easyUser = easyUser;
    }

    @Override public Result<PostCreatedDTO, String> createPost(PostCreateDTO postCreate) {
        //TODO: Auth

        var post = new  Post();
        post.setTitle(postCreate.getTitle());
        post.setDescription(postCreate.getDescription());
        post.setTextArticle(postCreate.getTextArticle());

        var user = easyUser.getUser();
        if(user.isEmpty()){
            return Result.resultError("You re not logged in");
        }
        post.setAuthorId(user.get().getId());
        postRepository.save(post);
        return Result.resultOk(postMapper.toPostCreatedDTO(post));
    }

    @Override public Result<Post, String> getPost(Long id) {
        Optional<Post> post = postRepository.getPostById(id);
        if(post.isEmpty()){
             return Result.resultError("Wrong id");
        }
        return Result.resultOk(post.get());
    }

    @Override public Result<String, String> deletePost(Long id) {
       Optional<User> user = easyUser.getUser();

       if(user.isEmpty()){
            return Result.resultError("You re not logged in");
        }
       Optional<Post> post = postRepository.findById(id);
       if(post.isEmpty()){
           return Result.resultError("Post with this id doesn't exists");
       }

       if(!Objects.equals(post.get().getAuthorId(), user.get().getId())&& !user.get().getPermissions().contains(Permissions.ADMIN)){
           return Result.resultError("You re not the author of this post");
       }
       postRepository.delete(post.get());
       return Result.resultOk("You deleted post with Id: "+post.get().getId());
    }

    @Override public Result<String, String> changePost(PostChangeDTO change) {
        return null;
    }
}
