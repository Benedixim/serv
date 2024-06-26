package com.example.ee;

import com.logic.DatabaseHandler;
import com.logic.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateServlet", urlPatterns = {"/update"})
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = databaseHandler.getUserById(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("second.jsp").forward(request, response);
    }
}

