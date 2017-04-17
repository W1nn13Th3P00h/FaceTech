package com.poly.repo;

import com.poly.mod.Like;
import com.poly.mod.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Winnie on 17/04/2017.
 */

@Repository
@Transactional
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost(Post post);
}
