package com.jj.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * @author JYM
 * @create 2019-05-14 23:10
 */
public class BaseServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String method = req.getParameter("method");
        if(method == null || "".equals(method) || method.trim().equals("")) {
            method = "execute";
        }

        Class clazz = this.getClass();
        try {
            Method md = clazz.getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            if(null != md) {
                String jspPath = (String)md.invoke(this,req,resp);
                if(jspPath != null) {
                    req.getRequestDispatcher(jspPath).forward(req,resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //默认方法
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException{
        return null;
    }
}
