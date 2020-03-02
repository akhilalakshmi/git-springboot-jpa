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

<form action="/msgsending" method="post">
     <%
        String name=(String)session.getAttribute("name");
     //   out.println(name);
        String id=(String)session.getAttribute("id");
     //   out.println(id);
        %>
<h1>Hello ${name}</h1>
    <hr>
    <table>
    <tr>
    <td>Subject</td><td> <input type="text" placeholder="Please enter subject" name="subname" required></td>
    </tr>
    <tr>
    <td>Message</td><td><textarea name="msgcontent" rows="12" cols="20"></textarea></td>
    </tr>
      <tr><td></td><td>  <button type="submit" class="editbtn">Edit</button></td></tr>
    </table>
</form>
</body>
</html>