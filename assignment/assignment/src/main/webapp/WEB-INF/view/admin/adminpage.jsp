<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

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

<form >
 

     <%
        String name=(String)session.getAttribute("name");
     //   out.println(name);
        String id=(String)session.getAttribute("id");
     //   out.println(id);
        %>
<h1>Hello ${name}</h1>
    <hr>


    <br>
    <a href="/profileadmin">Edit Profile</a>
    <br>
      <a href="/showalluser">View Users</a>
<br>
  <a href="/viewmessage">View Messages</a>
<br>
  <a href="/logout">Logout</a>
</form>

</body>
</html>