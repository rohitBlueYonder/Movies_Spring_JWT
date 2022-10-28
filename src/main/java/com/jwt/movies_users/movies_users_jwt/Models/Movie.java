package com.jwt.movies_users.movies_users_jwt.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private String releaseDate;


    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"name\":'" + name + '\'' +
                ", \"releaseDate\":'" + releaseDate + '\''+
                '}';
    }
}
