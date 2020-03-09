<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  <a href="/user/success">Home</a>
<form:form method="post" modelAttribute="msg"  action="/msgsending">

    <hr>${sucessmsg}
    <table>
    <tr>
    <td>Subject</td><td> <form:input path="subname"  /> </td>
    </tr>
    <tr>
    <td>Message</td><td><form:textarea path="msgcontent" rows="5" cols="30" /></td>
    </tr>
      <tr><td></td><td>  <button type="submit" class="editbtn">Send</button></td></tr>
    </table>

	<form:hidden path="id" />

		

	</form:form>    

</body>
</html>