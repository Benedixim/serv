<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        .content-columns {
            padding: 3rem;
            display: flex;
            background: #e5e5e9;
        }
        .content-columns .col {
            min-height: 500px;
            width: 200px;
            padding: 1rem;
            background: #ebecee;
            margin-right: 1rem;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.04);
            border-radius: 5px;
        }
        .content-columns .col1 {
            border-top: 4px solid #50aaee;
        }
        .content-columns .col2 {
            border-top: 4px solid #d56ec7;
        }
        .content-columns .col3 {
            border-top: 4px solid #e37e55;
        }
        .content-columns .col4 {
            border-top: 4px solid #ebbd41;
        }

        .item {
            background: white;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.07);
            min-height: 50px;
            border-radius: 5px;
            margin: 0 0 0.5rem 0;
        }
        body{
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            min-width: 320px;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<h1><%= new java.util.Date() %>
</h1>

<p>
    <%
        java.util.Date now = new java.util.Date();
        String someString = "Tekywaя data: " + now;

    %>
    <%= someString%>
    

</p>
<p >
    <%@ page import="java.util.Date, com.logic.Test" %>
    <%@ page import="com.logic.DatabaseHandlerTask" %>
    <%@ page import="com.logic.KanbanTask" %>
    <%@ page import="java.util.List" %>





</p>

<p>
</p>
<%--    <tr>--%>
<%--        <th class="col">Title</th>--%>
<%--        <th class="col">Description</th>--%>
<%--        <th class="col">Status</th>--%>
<%--        <th class="col">Actions</th>--%>
<%--    </tr>--%>
<div style="display: flex;">


<table class="content-columns">
    <tr>
        <th class="col1">К выполнению</th>
    </tr>
    <%
        DatabaseHandlerTask databaseHandler = new DatabaseHandlerTask();
        List<KanbanTask> tasks = databaseHandler.getAllUsers();

        for (KanbanTask task : tasks) {
            String status = task.getStatus();
            if (status.equals("К выполнению")) {
    %>
    <tr>
        <td class="item">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= task.getTitle() %></h5>
                    <p class="card-text"><%= task.getDescription() %></p>
                    <div class="d-flex align-items-center" style="gap: 30px;">
                        <form action="delete-task" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="update-task" method="get">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                        <form action="update-status" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-success ml-2">></button>
                        </form>
                    </div>
                </div>

            </div>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<table class="content-columns">
    <tr>
        <th class="col2">В работе</th>
    </tr>
    <%
        for (KanbanTask task : tasks) {
            String status = task.getStatus();
            if (status.equals("В работе")) {
    %>
    <tr>
        <td class="item">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= task.getTitle() %></h5>
                    <p class="card-text"><%= task.getDescription() %></p>
                    <div class="d-flex align-items-center" style="gap: 30px;">
                        <form action="delete-task" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="update-task" method="get">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                        <form action="update-status" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-success ml-2">></button>
                        </form>
                    </div>
                </div>

            </div>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<table class="content-columns">
    <tr>
        <th class="col3">Проверка</th>
    </tr>
    <%
        for (KanbanTask task : tasks) {
            String status = task.getStatus();
            if (status.equals("Проверка")) {
    %>
    <tr>
        <td class="item">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= task.getTitle() %></h5>
                    <p class="card-text"><%= task.getDescription() %></p>
                    <div class="d-flex align-items-center" style="gap: 30px;">
                        <form action="delete-task" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="update-task" method="get">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                        <form action="update-status" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-success ml-2">></button>
                        </form>
                    </div>
                </div>

            </div>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<table class="content-columns">
    <tr>
        <th class="col4">Готово</th>
    </tr>
    <%
        for (KanbanTask task : tasks) {
            String status = task.getStatus();
            if (status.equals("Готово")) {
    %>
    <tr>
        <td class="item">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= task.getTitle() %></h5>
                    <p class="card-text"><%= task.getDescription() %></p>
                    <div class="d-flex align-items-center" style="gap: 30px;">
                        <form action="delete-task" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                        <form action="update-task" method="get">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form>
                        <form action="update-status" method="post">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
                            <button type="submit" class="btn btn-success ml-2">></button>
                        </form>
                    </div>
                </div>

            </div>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</div>

<br>

<div class="container">
<form action="hello-servlet-task">
    <div class="form-group">
        <label for="size">Название:</label>
        <input type="text" class="form-control" name="kol" id="size">
    </div>
    <div class="form-group">
        <label for="lines">Описание:</label>
        <input type="text" class="form-control" name="px" id="lines">
    </div>
    <div class="form-group">
        <label for="status">Статус:</label>
        <select class="form-control" name="st" id="status">
            <option value="К выполнению">К выполнению</option>
            <option value="В работе">В работе</option>
            <option value="Проверка">Проверка</option>
            <option value="Готово">Готово</option>
        </select>
    </div>
    <br>
    <button type="submit" class="btn btn-primary">Add</button>
</form>
</div>

<br/>

</body>
</html>