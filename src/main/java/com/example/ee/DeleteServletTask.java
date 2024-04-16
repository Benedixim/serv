package com.example.ee;

import com.logic.DatabaseHandler;
import com.logic.DatabaseHandlerTask;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteServletTask", urlPatterns = {"/delete-task"})
public class DeleteServletTask extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("taskId"));
        DatabaseHandlerTask databaseHandler = new DatabaseHandlerTask();
        databaseHandler.deleteUser(userId);
        response.sendRedirect("/task");
    }
}

