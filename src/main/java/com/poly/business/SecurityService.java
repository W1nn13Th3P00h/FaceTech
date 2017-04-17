package com.poly.business;

/**
 * Created by Winnie on 14/04/2017.
 */
public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
