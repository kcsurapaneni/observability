package com.observability.user.model;

import com.observability.user.dto.*;
import jakarta.persistence.*;

import javax.xml.stream.events.*;
import java.util.*;

/**
 * @author Krishna Chaitanya
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private Integer id;

    private String name;

   @OneToMany
   @JoinColumn(name = "user_id")
    private List<UserComment> userCommentList;

    public List<UserComment> getUserCommentList() {
        return userCommentList;
    }

    public void setUserCommentList(List<UserComment> userCommentList) {
        this.userCommentList = userCommentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
