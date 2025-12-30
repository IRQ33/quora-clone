package net.irq3.blog.servicesImpl;

import net.irq3.blog.mappers.PostMapper;
import net.irq3.blog.models.Post;
import net.irq3.blog.models.dto.post.PostChangeDTO;
import net.irq3.blog.models.dto.post.PostCreateDTO;
import net.irq3.blog.models.dto.post.PostCreatedDTO;
import net.irq3.blog.repositories.PostRepository;
import net.irq3.blog.services.PostService;
import net.irq3.blog.utils.Result;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override public Result<PostCreatedDTO, String> createPost(PostCreateDTO postCreate) {
        //TODO: Auth

        var post = Post.builder()
                .title(postCreate.getTitle())
                .description(postCreate.getDescription())
                .textArticle(postCreate.getTextArticle())
                .build();

        postRepository.save(post);
        return Result.resultOk(postMapper.toPostCreatedDTO(post));
    }

    @Override public Result<Post, String> getPost(Long id) {
        return null;
    }

    @Override public Result<String, String> deletePost(Long id) {
        return null;
    }

    @Override public Result<String, String> changePost(PostChangeDTO change) {
        return null;
    }
}
