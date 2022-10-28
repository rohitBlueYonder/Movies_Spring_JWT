package com.jwt.movies_users.movies_users_jwt.Services;


import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository repository,TokenService tokenService) {
        this.repository = repository;
        this.tokenService = tokenService;
    }

    public User getUser(ObjectId id){
        Optional<User> result = repository.findById(id);
        return result.orElseGet(result::get);
    }


    public String signUp(User user){
        User savedUser = repository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created A User\","+
                "\"data\":"+savedUser+"}";
    }

    public String login(User user){
        List<User> repoUser = repository.getUsersByEmail(user.getEmail());

        if(repoUser.size()==0){

            return "{" +
                    "\"message\":"+"\"Authorization Failed\","+
                    "\"data\":"+user+"}";
        }
        if(!user.getPassword().equals(repoUser.get(0).getPassword())){
            return "{" +
                    "\"message\":"+"\"Authorization Failed\","+
                    "\"error\":"+"\"Email or Password is not correct\"}";
        }
        return "{" +
                "\"message\":"+"\"Successfully Login In\","+
                "\"data\":"+repoUser.get(0)+","+
                "\"token\":\""+tokenService.createToken(repoUser.get(0).getId())+"\"}";
    }


}
