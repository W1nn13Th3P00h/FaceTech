package com.poly.business;

import com.poly.mod.Comment;
import com.poly.mod.Like;
import com.poly.mod.Post;

import java.util.List;

/**
 * Created by Winnie on 14/04/2017.
 */
public interface PublicationService {
        void post(Post post);

        void like(Like like);

        //List<Like> fetchAllLike();

        List<Like> fetchAllLike(Post post);

        void comment(Comment comment);

       // List<Comment> fetchAllComment();

        Post fetchPost(Long id);

        List<Post> fetchAll();

        List<Comment> fetchAllComment(Post post);
    }

