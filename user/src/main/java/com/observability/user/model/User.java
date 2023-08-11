package com.observability.user.model;

import com.observability.user.dto.*;
import jakarta.persistence.*;

/**
 * @author Krishna Chaitanya
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static UserDTO to(User user) {
        return new UserDTO(user.getId(), user.getName());
    }

}
