package com.clouding.login;

import com.clouding.login.ModuleLogin.model.User;
import com.clouding.login.ModuleLogin.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserTest {

    @Autowired
    private UserService userService;

    //Logger
    protected static final Logger log = LoggerFactory.getLogger(UserTest.class);

    @Test
    public void testUserSave(){
        User user1 = new User("user1","email1","password1");
        userService.save(user1);
        Optional<User> user = userService.findByEmail("email1");
        assertTrue(user.isPresent());
        assertNotNull(user1);
        assertEquals("email1",user.get().getEmail());
        log.info("Testing creation of user  ********************");

        userService.delete(user.get().getId());


    }
}
