package net.irq3.blog.services;

import net.irq3.blog.models.Post;
import net.irq3.blog.models.dto.post.PostChangeDTO;
import net.irq3.blog.models.dto.post.PostCreateDTO;
import net.irq3.blog.models.dto.post.PostCreatedDTO;
import net.irq3.blog.utils.Result;

public interface PostService {
    Result<PostCreatedDTO, String> createPost(PostCreateDTO createDTO);
    Result<Post,String> getPost(Long id);
    Result<String, String> deletePost(Long id);
    Result<String, String> changePost(PostChangeDTO change);

}
