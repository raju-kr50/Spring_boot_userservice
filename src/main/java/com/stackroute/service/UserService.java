package com.stackroute.service;

import com.stackroute.domain.User;

public interface UserService {

    public User saveUser(User user);

    public User getUser(int id);
}
