package com.poly.business;

import com.poly.mod.Comment;
import com.poly.mod.Like;
import com.poly.mod.Post;
import com.poly.repo.CommentRepository;
import com.poly.repo.LikeRepository;
import com.poly.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Winnie on 17/04/2017.
 */

@Component
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private CommentRepository commentRepository;

    public void post(Post post){
        postRepository.save(post);
    }

    @Override
    public void like(Like like){
        likeRepository.save(like);
    }

    //@Override
    public List<Like> fetchAllLike() {
        return likeRepository.findAll();
    }

    @Override
    public List<Like> fetchAllLike(Post post) {
        return likeRepository.findByPost(post);
    }

    @Override
    public void comment(Comment comment) {
        commentRepository.save(comment);
    }

    //@Override
    public List<Comment> fetchAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Post fetchPost(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> fetchAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Comment> fetchAllComment(Post post) {
        return commentRepository.findByPost(post);
    }
}
