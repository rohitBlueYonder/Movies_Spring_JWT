package com.jwt.movies_users.movies_users_jwt.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


@Data // it will take care all CURD
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String name;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +"\""+
                ", \"name\":'" + name + '\'' +
                ", \"email\":'" + email + '\'' +
                ", \"password\":'" + password + '\'' +
                '}';
    }
}
