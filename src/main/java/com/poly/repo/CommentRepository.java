package com.poly.repo;

import com.poly.mod.Comment;
import com.poly.mod.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Winnie on 14/04/2017.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
