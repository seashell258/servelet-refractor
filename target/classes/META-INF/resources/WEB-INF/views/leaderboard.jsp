<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Leaderboard</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f0f0f0; }
    </style>
</head>
<body>
<h2>Leaderboard</h2>
<table>
    <tr>
        <th>Rank</th>
        <th>Name</th>
        <th>Score</th>
    </tr>
    <c:forEach var="score" items="${scores}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td> <!-- 排名從1開始 -->
            <td>${score.name}</td>
            <td>${score.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
