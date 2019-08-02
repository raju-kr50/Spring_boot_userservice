package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.exceotions.UserAlreadyExistException;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            responseEntity = new ResponseEntity<String>("Succesfully created", HttpStatus.CREATED);
        } catch (UserAlreadyExistException ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        User user1 = userService.getUser(id);
        return new ResponseEntity<User>(user1,HttpStatus.OK);

    }

}
