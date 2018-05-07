package com.example.action;

import com.example.entity.Users;
import com.example.service.UsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 用户Action类
 * @author: Mr.Eight
 * @date: 5.7
 **/
@Controller
@Scope("prototype")
public class UsersAction extends ActionSupport {
    @Resource
    private UsersService usersService;

    private Users users; // 接收users对象

    /**
     * 用户注册
     * @return success
     */
    public String addUser(){
        usersService.addUsers(users);
        return "success";
    }


    /**
     * 用户登录
     * @return 重定向到主页
     */
    public String login(){
        Users u = usersService.getUsers(users);
        if(u != null){
            ActionContext.getContext().getSession().put("users", u);
        }
        return "index";
    }

    /**
     * 注销登录
     * @return success
     */
    public String logout(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        if(session.get("users") != null){
            session.remove("users");
        }
        return "success";
    }

    /**
     * 修改资料
     * @return success
     */
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
