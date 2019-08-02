package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exceotions.UserAlreadyExistException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    private UserRepository userRepository;

    public UserServiceImple() {
    }

    @Autowired
    public UserServiceImple(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User saveUser(User user)throws UserAlreadyExistException {
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistException("User already exist");
        }
        User savedUser = userRepository.save(user);
        if (savedUser==null){
            throw new UserAlreadyExistException("User already exist");
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).get();
    }
}
