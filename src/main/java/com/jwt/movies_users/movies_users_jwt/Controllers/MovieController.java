package com.jwt.movies_users.movies_users_jwt.Controllers;


import com.jwt.movies_users.movies_users_jwt.Models.Movie;
import com.jwt.movies_users.movies_users_jwt.Models.User;
import com.jwt.movies_users.movies_users_jwt.Services.MovieService;
import com.jwt.movies_users.movies_users_jwt.Services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService service;


    @PostMapping(value = "/saveMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @GetMapping("/getMovies")
    public List<Movie> GatMovie(HttpServletRequest req, HttpServletResponse res) throws IOException {
        return  service.getMovies();
    }

}
