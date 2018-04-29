package com.example.service;

import com.example.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UsersService {
    /**
     * add users
     *
     * @param users
     */
    public void addUsers(Users users);

    /**
     * search users
     *
     * @param users
     * @return
     */
    public Users getUsers(Users users);

    /**
     * uodate users
     *
     * @param users
     */
    public void updateUsers(Users users);


}
