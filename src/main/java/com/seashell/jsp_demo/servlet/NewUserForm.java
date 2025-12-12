package com.seashell.jsp_demo.servlet;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.seashell.jsp_demo.domain_object.User;
import com.seashell.jsp_demo.repository.UserRepository;


@WebServlet("/register")
public class NewUserForm extends HttpServlet {

    
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
System.out.println("registered get calledd");

        req.getRequestDispatcher("/WEB-INF/views/new-user.jsp").forward(req, resp);
        System.out.println("forward to new user");
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String name = req.getParameter("name");
    String password = req.getParameter("password");
    String email = req.getParameter("email");

    if (name == null || password == null || email == null) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
        return;
    }

    byte status = 1;


    User newUser = new User(name,password,email,status);

    userRepository.save(newUser);

    // 新增完 redirect 避免 F5 重複提交
    resp.sendRedirect(req.getContextPath() + "/register");
}

}
