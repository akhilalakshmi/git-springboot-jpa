<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  <a href="/user/success">Home</a>
			<h2 >Your informations</h2>
			
					<p >${msg}</p>	
<form:form method="post" modelAttribute="user"  action="/updateuser">
	<form:hidden path="id" />
Name<form:input path="name"  /> 
Password<form:input path="password"  /> 	
Email	<form:input path="email"  /> 			
		<button type="submit">Update</button>		
	</form:form>      