package com.clouding.login.ModuleLogin.RestController;

import com.clouding.login.ModuleLogin.Errors.UserNotFoundException;
import com.clouding.login.ModuleLogin.model.User;
import com.clouding.login.ModuleLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(UserResource.class);

    @Autowired
    UserService userService;

    @GetMapping("/user/")
    public List<EntityModel<User>> getAllUser(){
        List<User> users   =   userService.listAll();
        List<EntityModel<User>> usersResources = users.stream()
                .map(user -> EntityModel.of(user,
                        linkTo(methodOn(UserResource.class).getUser(user.getId())).withSelfRel(),
                        linkTo(methodOn(UserResource.class).getAllUser()).withRel("user")))
                .collect(Collectors.toList());
        return usersResources;
    }


    @GetMapping("/user/{id}")
    public EntityModel<User> getUser(@PathVariable int  id)  {
        User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        log.info(user.toString());
        return  EntityModel.of(user,
                linkTo(methodOn(UserResource.class).getUser(id)).withSelfRel(),
                linkTo(methodOn(UserResource.class).getAllUser()).withRel("user"));
    }


}
