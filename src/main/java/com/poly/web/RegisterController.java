package com.poly.web;

import com.poly.business.SecurityService;
import com.poly.business.UserService;
import com.poly.business.UserValidator;
import com.poly.mod.Role;
import com.poly.mod.User;
import com.poly.repo.RoleRepository;
import com.poly.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

/**
 * Created by Winnie on 14/04/2017.
 */
@Controller
public class RegisterController {

    UserRepository userRepository;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String createAccountForm(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        System.out.println(bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userForm.setRoles(new HashSet<Role>());
        userForm.getRoles().add(roleRepository.findAll().get(0));

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/";
    }

}
