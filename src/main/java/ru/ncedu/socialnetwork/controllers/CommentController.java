package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.api.models.CommentDTO;
import ru.ncedu.socialnetwork.api.models.LikeCommentDTO;
import ru.ncedu.socialnetwork.domain.CommentDAO;
import ru.ncedu.socialnetwork.domain.LikeCommentDAO;
import ru.ncedu.socialnetwork.domain.PostDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.CommentRepository;
import ru.ncedu.socialnetwork.repositories.LikeCommentRepository;
import ru.ncedu.socialnetwork.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final LikeCommentRepository likeCommentRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, PostRepository postRepository,
                             LikeCommentRepository likeCommentRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.likeCommentRepository = likeCommentRepository;
    }

    @GetMapping
    public List<CommentDTO> getComments() {
        List<CommentDAO> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOList = new ArrayList<>();
        CommentDTO commentDTO;

        for (CommentDAO comment : comments) {
            commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setPostId(comment.getPost().getPostId());
            commentDTO.setUser(comment.getUser());
            commentDTO.setContent(comment.getContent());
            commentDTO.setDate(comment.getDate());
            commentDTO.setLikes(comment.getLikes());
            commentDTOList.add(commentDTO);
        }

        return commentDTOList;
    }

    @PostMapping
    public void addComment(@AuthenticationPrincipal UserDAO user, @RequestBody CommentDTO commentDTO) {
        CommentDAO newComment = new CommentDAO();
        PostDAO post = postRepository.findOne(commentDTO.getPostId());

        newComment.setPost(post);
        newComment.setUser(user);
        newComment.setDate(new Date());
        newComment.setContent(commentDTO.getContent());

        commentRepository.save(newComment);
    }

    @RequestMapping("/likes")
    public void updateCommentLike(@AuthenticationPrincipal UserDAO user, @RequestBody LikeCommentDTO likeCommentDTO) {
         CommentDAO comment = commentRepository.findOne(likeCommentDTO.getCommentId());
         LikeCommentDAO like = likeCommentRepository.findLikeCommentDAOByCommentAndUser(comment, user);

        if (like != null && !likeCommentDTO.isLikeValue()) {
            likeCommentRepository.delete(like);
        } else if ((likeCommentRepository.findAll().isEmpty() || like == null) && likeCommentDTO.isLikeValue()) {
            like = new LikeCommentDAO();
            like.setComment(comment);
            like.setUser(user);
            likeCommentRepository.save(like);
        }
    }
}
