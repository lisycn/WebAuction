package com.example.interceptor;

import java.util.Map;

import com.example.entity.Users;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.springframework.stereotype.Component;

public class LoginInterceptor implements Interceptor {
    public String intercept(ActionInvocation arg0) throws Exception {
        Map<String, Object> session = arg0.getInvocationContext().getSession();
        Users u = (Users) session.get("users");
        if (u != null)
            return arg0.invoke();
        else
            return "login";
    }

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void init() {
        // TODO Auto-generated method stub

    }


}
