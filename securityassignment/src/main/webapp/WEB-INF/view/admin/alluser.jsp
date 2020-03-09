<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- include jstl dependancy in pom -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body {
  background-image: url('https://cdn.auth0.com/blog/illustrations/spring.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
</head>
<body>
  <a href="/user/success">Home</a>
<table border="2">
<tr>
<td>Id</td><td>email</td><td>Address</td><td>Edit</td><td>Delete</td>
</tr>
<c:forEach items="${users}" var="user">
    <tr>      
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td><a href="/updateUserdetails?id=${user.id}">Edit</a></td>
      <td><a href="/deleteUser?id=${user.id}">Delete</a></td>
        
    </tr>
</c:forEach>
</table>
</body>
</html>