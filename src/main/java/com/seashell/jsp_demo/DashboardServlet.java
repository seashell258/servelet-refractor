package com.seashell.jsp_demo;

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
 /*
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
*/

@WebServlet("/aaa")
public class DashboardServlet extends HttpServlet {

    @Autowired
    private UserRepository userRepository;

/*  一般情況下用建構子注入比較好，可以在測試的時候注入mock 不需要模擬 spring 環境的自動注入。 
但 tomcat 在呼叫 servlet 實例的時候都會固定用無參數建構子，所以自己寫建構子注入是沒用的

    public DashboardServlet(UserRepository userRepository) {
                this.userRepository = userRepository;
    }
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
System.out.println("do get calledd");
        User user=userRepository.findById(1);
        System.out.println("fetched user");

        req.setAttribute("user", user);
        System.out.println("set req user dataa");

        // 3. forward 到 JSP  //從webapp根目錄找起路徑
        req.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(req, resp);
        System.out.println("forwarded");
    }
}
