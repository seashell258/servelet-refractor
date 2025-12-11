package com.seashell.jsp_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan  // 掃描 @WebServlet 註解
public class JspDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JspDemoApplication.class, args);
    }
}
