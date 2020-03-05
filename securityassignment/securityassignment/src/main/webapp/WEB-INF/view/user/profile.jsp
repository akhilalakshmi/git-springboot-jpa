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
<form action="/updateuser " method="post">
  <div class="container">
    <h1>Edit</h1>
  
    <hr>

    <label for="email"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="name"  value="${userdet.name}" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" value="${userdet.password}" required>

    <label for="psw-repeat"><b>Address</b></label>
    <input type="address" placeholder="address" name="address"  value="${userdet.address}"required>
    <hr>

   
    <button type="submit" class="registerbtn">Update</button>
  
  </div>


</form>
</body>
</html>