package com.example.service.impl;

import com.example.dao.UsersDao;
import com.example.entity.Users;
import com.example.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@Service(value = "usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public void addUsers(Users users) {
        usersDao.addUsers(users);
    }

    @Override
    public Users getUsers(Users users) {
        List<Users> list = usersDao.getUsers(users);
        Iterator<Users> iterator = list.iterator();
        if (iterator.hasNext()){
            return iterator.next();
        }
        return null;
    }

    @Override
    public void updateUsers(Users users) {
        usersDao.updateUsers(users);
    }
}
