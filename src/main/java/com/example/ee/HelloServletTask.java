package com.example.ee;

import com.logic.DatabaseHandler;
import com.logic.DatabaseHandlerTask;
import com.logic.KanbanTask;
import com.logic.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet(name = "helloServletTask", value = "/hello-servlet-task")
public class HelloServletTask extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public String getUser(String title, String description, String status) throws IOException {
        DatabaseHandlerTask dbHandler = new DatabaseHandlerTask();
        KanbanTask user = dbHandler.getUser(title, description, status);
        System.out.println(user.getTitle() + " " + user.getDescription() + " " + user.getStatus());
        return  "<tr><td>" + user.getTitle() + "</td><td>" + user.getDescription() + "</td><td>" + user.getStatus() + "</td></tr>";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {session.setAttribute("count", 1); count = 1;}
        else  session.setAttribute("count", count + 1);



        String username = request.getParameter("kol");
        String password = request.getParameter("px");
        String status = request.getParameter("st");
        //System.out.println(username + " " + password + " " + status);

        DatabaseHandlerTask dbHandler = new DatabaseHandlerTask();
        if(username != null && password != null && status != null) {
            dbHandler.signup(username, password, status);
        }

       // RequestDispatcher dispatcher = request.getRequestDispatcher("/second");
        //dispatcher.forward(request, response);
        response.sendRedirect("/task");
    }

    public void destroy() {
    }
}