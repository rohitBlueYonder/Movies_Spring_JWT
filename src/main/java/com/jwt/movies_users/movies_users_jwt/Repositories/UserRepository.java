package com.jwt.movies_users.movies_users_jwt.Repositories;


import com.jwt.movies_users.movies_users_jwt.Models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    @Query("{email:\"?0\"}")
    public List<User> getUsersByEmail(String email);
}
