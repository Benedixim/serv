<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.logic.KanbanTask" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form action="updateSelfTask" method="post">
    <input type="hidden" name="userId" value="${task.getId()}">
    <div class="form-group">
        <label for="title">Title:</label>
        <input type="text" class="form-control" id="title" name="title" value="${task.getTitle()}">
    </div>
    <div class="form-group">
        <label for="description">Description:</label>
        <input type="text" class="form-control" id="description" name="description" value="${task.getDescription()}">
    </div>
    <div class="form-group">
        <label for="status">Status:</label>
        <select class="form-control" id="status" name="status">
            <option value="К выполнению" ${task.getStatus().equals("К выполнению") ? "selected" : ""}>К выполнению</option>
            <option value="В работе" ${task.getStatus().equals("В работе") ? "selected" : ""}>В работе</option>
            <option value="Проверка" ${task.getStatus().equals("Проверка") ? "selected" : ""}>Проверка</option>
            <option value="Готово" ${task.getStatus().equals("Готово") ? "selected" : ""}>Готово</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Update Task</button>
</form>
</div>
</body>
</html>