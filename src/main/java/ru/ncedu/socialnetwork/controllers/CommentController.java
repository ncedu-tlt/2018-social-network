package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.CommentDTO;
import ru.ncedu.socialnetwork.domain.CommentDAO;
import ru.ncedu.socialnetwork.domain.PostDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.CommentRepository;
import ru.ncedu.socialnetwork.repositories.PostRepository;

import java.util.Date;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void addComment(@AuthenticationPrincipal UserDAO user, @RequestBody CommentDTO commentDTO) {
        CommentDAO newComment = new CommentDAO();
        PostDAO post = postRepository.findOne(commentDTO.getPostId());

        newComment.setPost(post);
        newComment.setUser(user);
        newComment.setDate(new Date());
        newComment.setContent(commentDTO.getContent());
        newComment.setLikeComment(commentDTO.isLikeComment());

        commentRepository.save(newComment);
    }

    @RequestMapping("/likes")
    public void updateCommentLike(@RequestBody CommentDTO commentDTO) {
        CommentDAO updateComment = commentRepository.findOne(commentDTO.getId());
        updateComment.setLikeComment(commentDTO.isLikeComment());
        commentRepository.save(updateComment);
    }
}
