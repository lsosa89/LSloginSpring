package com.clouding.login.ModuleLogin.Errors;

public class UserNotFoundException  extends  RuntimeException{
    public UserNotFoundException(int id){
        super  (String.format("User with id %d not found",id));
    }
}
