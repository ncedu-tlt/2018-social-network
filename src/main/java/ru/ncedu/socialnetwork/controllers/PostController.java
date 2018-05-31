package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.api.models.LikePostDTO;
import ru.ncedu.socialnetwork.api.models.PostDTO;
import ru.ncedu.socialnetwork.domain.LikePostDAO;
import ru.ncedu.socialnetwork.domain.PostDAO;
import ru.ncedu.socialnetwork.domain.PostTypeDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.LikePostRepository;
import ru.ncedu.socialnetwork.repositories.PostRepository;
import ru.ncedu.socialnetwork.repositories.PostTypeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final PostTypeRepository postTypeRepository;
    private final LikePostRepository likePostRepository;

    @Autowired
    public PostController(PostRepository postRepository, PostTypeRepository postTypeRepository,
                          LikePostRepository likePostRepository) {
        this.postRepository = postRepository;
        this.postTypeRepository = postTypeRepository;
        this.likePostRepository = likePostRepository;
    }

    @GetMapping
    public List<PostDTO> getPosts() {
        List<PostDAO> posts = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        PostDTO postDTO;


        for (PostDAO post : posts) {
            postDTO = new PostDTO();

            postDTO.setId(post.getPostId());
            postDTO.setUser(post.getUser());
            postDTO.setDate(post.getDate());
            postDTO.setType(post.getType().getType());
            postDTO.setContent(post.getContent());
            postDTO.setLikes(post.getLikes());

            postDTOList.add(postDTO);
        }

        return postDTOList;
    }

    @PostMapping
    public void createPost(@AuthenticationPrincipal UserDAO user, @RequestBody PostDTO postDTO) {
        PostDAO newPost = new PostDAO();
        PostTypeDAO postType = new PostTypeDAO();

        List<PostTypeDAO> postTypeList = postTypeRepository.findAll();
        for (int i = 0; i < postTypeRepository.findAll().size(); i++) {
            if (postTypeList.get(i).getType().equals(postDTO.getType())) {
                postType.setPostTypeId(postTypeList.get(i).getPostTypeId());
            }
        }

        newPost.setUser(user);
        newPost.setType(postType);
        newPost.setDate(new Date());
        newPost.setContent(postDTO.getContent());

        postRepository.save(newPost);
    }

    @RequestMapping("/likes")
    public void updatePostLike(@AuthenticationPrincipal UserDAO user, @RequestBody LikePostDTO likePostDTO) {
        PostDAO post = postRepository.findPostDAOByPostIdAndUser(likePostDTO.getPostId(), user);
        LikePostDAO like = likePostRepository.findLikePostDAOByPostAndUser(post, user);

        if (like != null && !likePostDTO.isLikeValue()) {
            likePostRepository.delete(like);
        } else if ((likePostRepository.findAll().isEmpty() || like == null) && likePostDTO.isLikeValue()) {
            like = new LikePostDAO();
            like.setUser(user);
            like.setPost(post);
            likePostRepository.save(like);
        }
    }
}
