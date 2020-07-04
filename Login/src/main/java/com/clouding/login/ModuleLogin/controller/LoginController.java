package com.clouding.login.ModuleLogin.controller;

import com.clouding.login.ModuleLogin.model.User;
import com.clouding.login.ModuleLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    UserService userService;
    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public void login() {
    }

    @RequestMapping("/")
    public String index() {
        return "/login";
    }

    @PostMapping("/loginAuth")
    public RedirectView authUser(@RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password){
        RedirectView mvc = new RedirectView("/login");
        Optional<User> userOp = userService.findByEmail(email);
        boolean userDontExists = !userOp.isPresent();

        if(  userDontExists ){
            mvc.addStaticAttribute("errorUser","errorUser");
            log.info("This is a example of log");
            return mvc;
        }
        User user = userOp.get();
        boolean wrongPassword = ! user.getPassword().equals(password);
        if(  wrongPassword ){
            mvc.addStaticAttribute("errorPassword","errorPassword");
            log.info("Password does not match");
            return mvc;
        }
        log.info(String.format("Printing User: %s",user.toString()));
        mvc = new RedirectView(String.format("user/%d",user.getId()));
        return  mvc ;
    }




}
