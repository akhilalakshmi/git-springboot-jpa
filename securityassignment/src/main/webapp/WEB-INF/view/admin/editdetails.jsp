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
<form action="/editUser" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="hidden" name="id"  value="${userdetails.id}">
    <input type="text" placeholder="${userdetails.name}" name="name"  value="${userdetails.name}" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="${userdetails.password}" name="password"   value="${userdetails.password}" required>

    <label for="psw-repeat"><b>Address</b></label>
    <input type="address" placeholder="${userdetails.address}" name="address"  value="${userdetails.address}" required>
    <hr>

   
    <button type="submit" class="editbtn">Edit</button>
  
  </div>


</form>
</body>
</html>