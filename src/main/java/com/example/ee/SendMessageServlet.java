package com.example.ee;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "SendMessageServlet", urlPatterns = {"/SendMessageServlet"} )
public class SendMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Sending message");
        String text = req.getParameter("text") != null ? req.getParameter("text") : "Hello World";

        Context ic = null; // Declare the Context object outside the try block
        try {
            ic = new InitialContext();
            ConnectionFactory cf = (ConnectionFactory) ic.lookup("/ConnectionFactory");
            Queue queue = (Queue) ic.lookup("queue/tutorialQueue");
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(queue);

            connection.start();

            TextMessage message = session.createTextMessage(text);
            publisher.send(message);

            res.getWriter().println("Message sent: " + text);
        } catch (NamingException | JMSException e) {
            res.getWriter().println("Error while trying to send <" + text + "> message: " + e.getMessage());
        } finally {
            if (ic != null) {
                try {
                    ic.close(); // Close the Context object
                } catch (NamingException e) {
                    // Handle the exception if needed
                }
            }
        }
    }
}