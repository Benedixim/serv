package com.example.ee;

import com.logic.DatabaseHandlerTask;
import com.logic.KanbanTask;
import com.logic.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateServletTask", urlPatterns = {"/update-task"})
public class UpdateServletTask extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        DatabaseHandlerTask databaseHandler = new DatabaseHandlerTask();
        KanbanTask task = databaseHandler.getUserById(taskId);
        request.setAttribute("task", task);
        request.getRequestDispatcher("task2.jsp").forward(request, response);
    }
}

