package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostTypeRepository postTypeRepository;

    @Autowired
    private LikePostRepository likePostRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<PostDTO> getPosts() {
        List<PostDAO> posts = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();

        PostDTO postDTO;

        for (int i = 0; i < postRepository.findAll().size(); i++) {
            postDTO = new PostDTO();

            postDTO.setId(posts.get(i).getPostId());
            postDTO.setUser(posts.get(i).getUser());
            postDTO.setDate(posts.get(i).getDate());
            postDTO.setType(posts.get(i).getType().getType());
            postDTO.setContent(posts.get(i).getContent());
            postDTO.setComments(posts.get(i).getComments());
            postDTO.setLikes(posts.get(i).getLikes());

            postDTOList.add(postDTO);
        }

        return postDTOList;
    }

    @RequestMapping(method = RequestMethod.POST)
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

        if (like != null && !likePostDTO.getLikeValue()) {
            likePostRepository.delete(like);
        } else if ((likePostRepository.findAll().isEmpty() || like == null) && likePostDTO.getLikeValue()) {
            like = new LikePostDAO();
            like.setUser(user);
            like.setPost(post);
            likePostRepository.save(like);
        }
    }
}
