<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>User Info</h1>
    <p>ID: ${user.id}</p>
    <p>Username: ${user.username}</p>
    <p>Email: ${user.email}</p>
    <p>Status: ${user.status}</p>
</body>
</html>

