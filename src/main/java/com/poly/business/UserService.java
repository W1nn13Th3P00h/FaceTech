package com.poly.business;

import com.poly.mod.User;

/**
 * Created by Winnie on 14/04/2017.
 */
public interface UserService {
    void save(User user);
    User findByUsername(String username);
}

