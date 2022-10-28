package com.jwt.movies_users.movies_users_jwt.Services;


import com.jwt.movies_users.movies_users_jwt.Models.Movie;
import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Repositories.MovieRepository;
import com.jwt.movies_users.movies_users_jwt.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private TokenService tokenService;

    public List<Movie> getMovies(){
        List<Movie> result = repository.findAll();
        return result;
    }

    public String saveMovie(Movie movie){
        Movie savedMovie = repository.save(movie);
        return "{" +
                "\"message\":"+"\"Successfully Created A Movie\","+
                "\"data\":"+savedMovie+"}";
    }
}
