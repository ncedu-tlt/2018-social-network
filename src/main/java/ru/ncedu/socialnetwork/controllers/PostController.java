package ru.ncedu.socialnetwork.controllers;

import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.api.models.PostDTO;
import ru.ncedu.socialnetwork.domain.PostDAO;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PostDTO> getPosts() {
        List<PostDTO> postList = new ArrayList<>();
        PostDTO postDTO = new PostDTO();
        postList.add(postDTO);
        return postList;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public PostDAO addPost(Principal user, @RequestBody PostDAO post) {
        System.out.println(post);
        return post;
    }
}
