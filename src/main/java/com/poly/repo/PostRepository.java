package com.poly.repo;

import com.poly.mod.Post;

import java.util.List;

/**
 * Created by Winnie on 14/04/2017.
 */
public interface PostRepository {
    void save(Post post);
    Post findById(long id);
    List<Post> findAll();
}
