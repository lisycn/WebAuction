package com.example.action;

import com.example.entity.Users;
import com.example.service.UsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@Scope("prototype")
public class UsersAction extends ActionSupport {
    @Resource
    private UsersService usersService;

    private Users users;

    public String addUser(){
        usersService.addUsers(users);
        return "success";
    }


    public String login(){
        Users u = usersService.getUsers(users);
        if(u != null){
            ActionContext.getContext().getSession().put("users", u);
        }
        return "index";
    }

    public String logout(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        if(session.get("users") != null){
            session.remove("users");
        }
        return "success";
    }

    public String changePassword(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        Users u = (Users) session.get("users");
        u.setPassword(users.getPassword());
        session.put("users", u);
        usersService.updateUsers(u);
        return "success";
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
