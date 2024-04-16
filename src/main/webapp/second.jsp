<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.logic.User" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update User</title>
</head>
<body>
<form action="updateSelf" method="post">
    <input type="hidden" name="userId" value="${user.getId()}">
    Username: <input type="text" name="username" value="${user.getUserName()}"><br>
    Password: <input type="password" name="password" value="${user.getPassword()}"><br>
    <input type="submit" value="Update User">
</form>
</body>
</html>