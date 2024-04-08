<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Users</title>
</head>
<body>
<h1>Users</h1>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.age}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
