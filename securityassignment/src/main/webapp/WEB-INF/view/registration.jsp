<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
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
<form action="/adduser" method="post">
  <div class="container">
    <h1>Register</h1><b>${roletype }<b>
    <p>Please fill in this form to create an account.</p>
    <hr>${msg}<br>${errorMsg}

  <b>Name</b>
    <input type="text" placeholder="Enter Name" name="name" required>

    <b>Password</b>
    <input type="password" placeholder="Enter Password" name="password" required>

   <b>Email</b>
    <input type="email" placeholder="email" name="email" required>
   <b>Privilege</b>
<input type="text"  name="rolename"  value="${roletype }" readonly="readonly">
     <hr>
    <button type="submit" class="registerbtn">Register</button>
  
  </div>


</form>
</body>
</html>