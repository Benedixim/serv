package com.example.ee;

import java.io.*;

import com.logic.DatabaseHandler;
import com.logic.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public String getUser(String username, String password) throws IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = dbHandler.getUser(username, password);
        System.out.println(user.getUserName() + " " + user.getPassword());
        return  "<tr><td>" + user.getUserName() + "</td><td>" + user.getPassword() + "</td></tr>";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {session.setAttribute("count", 1); count = 1;}
        else  session.setAttribute("count", count + 1);



        String username = request.getParameter("kol");
        String password = request.getParameter("px");
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.signupUser(username, password);

       // RequestDispatcher dispatcher = request.getRequestDispatcher("/second");
        //dispatcher.forward(request, response);
        response.sendRedirect("/");
    }

    public void destroy() {
    }
}