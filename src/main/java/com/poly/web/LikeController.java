package com.poly.web;

import com.poly.business.PublicationService;
import com.poly.mod.Like;
import com.poly.mod.Post;
import com.poly.mod.User;
import com.poly.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Winnie on 14/04/2017.
 */

@Controller
public class LikeController {
    @Autowired
    private PublicationService publicationService;

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(value = "/likes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Like like(@RequestParam(value="id", required=true) Long idPost, Principal principal){
        Post post = publicationService.fetchPost(idPost);
        Like like = new Like(post, userRepository.findByUsername(principal.getName()));
        publicationService.like(like);
        return like;
    }

    @ResponseBody
    @RequestMapping(value = "/likes/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String likeCount(@RequestParam(value="id", required=true) Long idPost){
        Post post = publicationService.fetchPost(idPost);
        List<Like> likes = publicationService.fetchAllLike(post);
        String template = "{\"Post\" : %s, \"likes_count\" : %d }";
        return String.format(template, post.toString(), likes.size());
    }

    @ResponseBody
    @RequestMapping(value = "/likes/for", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> likeFor(@RequestParam(value="id", required=true) Long idPost){
        Post post = publicationService.fetchPost(idPost);
        List<Like> likes = publicationService.fetchAllLike(post);
        List<User> likers = new LinkedList<>();
        for (Like l : likes){
            likers.add(l.getAuthor());
        }
        return likers;
    }
}
