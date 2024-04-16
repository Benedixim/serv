package com.example.ee;

import com.logic.DatabaseHandler;
import com.logic.DatabaseHandlerTask;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateServletSelfTask", urlPatterns = {"/updateSelfTask"})
public class UpdateServletSelfTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseHandlerTask dbHandler = new DatabaseHandlerTask();


        Long userId = Long.valueOf(request.getParameter("userId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        System.out.println(title + " " + description + " " + status);
        dbHandler.updateUser(title, description, status, userId);


        response.sendRedirect("/task");


    }
}
