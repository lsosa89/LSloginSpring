package com.clouding.login.ModuleLogin.service;


import com.clouding.login.ModuleLogin.model.User;
import com.clouding.login.ModuleLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> listAll(){
        return (List<User>) userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public Optional<User> findById(Integer userID){
        return  userRepository.findById(userID);
    }


public Optional<User> findByEmail(String email){
        if(Objects.isNull(email) || email.isEmpty()){
            return Optional.empty();
        }
        return   userRepository.findByEmail(email);
    }

    public void delete (Integer userId){
        userRepository.deleteById(userId);
    }
}
