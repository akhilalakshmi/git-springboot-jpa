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

<form action="/login" method="post">
 
    <h1>Login</h1>
			<p class="text-center ${error != null ? 'txt-error' : 'txt-success'}">${msg}</p>
    <hr>

  <b>Username</b>
    <input type="text" placeholder="Enter username" name="username" required>

  <b>Password</b>
    <input type="password" placeholder="Enter Password" name="password" required>

   

    <button type="submit" class="loginbtn">Login</button>
    <br>
    <a href="/registeradmin">Admin Registration</a>
    <a href="/registeruser">User Registration</a>
    <br>
 

  
</form>

</body>
</html>