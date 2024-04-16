package com.example.ee;

import com.logic.DatabaseHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateServletSelf", urlPatterns = {"/updateSelf"})
public class UpdateServletSelf extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseHandler dbHandler = new DatabaseHandler();


        Long userId = Long.valueOf(request.getParameter("userId"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        dbHandler.updateUser(username, password, userId);


        response.sendRedirect("/");


    }
}
