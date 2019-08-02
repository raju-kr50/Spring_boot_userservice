package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceotions.UserAlreadyExistException;

public interface UserService  {

    public User saveUser(User user) throws UserAlreadyExistException;

    public User getUser(int id);
}
