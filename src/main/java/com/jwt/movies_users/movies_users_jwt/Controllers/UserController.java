package com.jwt.movies_users.movies_users_jwt.Controllers;

import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value = "/signUp" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        return userService.signUp(user);
    }


    @PostMapping(value = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginAUser(@RequestBody User user){
        return userService.login(user);
    }


    @GetMapping("/getUser/{id}")
    public User GatUser(@PathVariable("id") ObjectId id)  {
        return  userService.getUser(id);
    }

}

