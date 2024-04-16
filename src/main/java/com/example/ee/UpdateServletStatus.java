package com.example.ee;

import com.logic.DatabaseHandlerTask;
import com.logic.KanbanTask;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "UpdateServletStatus", urlPatterns = {"/update-status"})
public class UpdateServletStatus extends HttpServlet {

    String[] statuses = {"К выполнению", "В работе", "Проверка", "Готово", "Завершено"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskId"));
        DatabaseHandlerTask databaseHandler = new DatabaseHandlerTask();
        KanbanTask task = databaseHandler.getUserById(taskId);

        String currentStatus = task.getStatus();
        int currentIndex = Arrays.asList(statuses).indexOf(currentStatus);
        int nextIndex = (currentIndex + 1) % statuses.length; // Циклическое обновление статуса
        String nextStatus = statuses[nextIndex];

        task.setStatus(nextStatus);
        databaseHandler.updateUser(task.getTitle(), task.getDescription(), task.getStatus(), task.getId());

        response.sendRedirect("/task");
    }
}

