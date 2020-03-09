<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="post" modelAttribute="msgctnt"  >
<c:if test="${msgctnt.subname != null}"/>
   <!-- Now I can access safely to "myAttribute" -->

<table border="2" class="table" id="theTable">
<tr>
<td>Send From</td>
<td>Email Id</td><td>Subject</td><td>Content</td>
</tr><tr>
<td>${msgctnt.user.name}</td>
<td>${msgctnt.user.email}</td>
<td>${msgctnt.subname}</td>
<td>${msgctnt.msgcontent}</td>

</tr>
	    

</table>
</form:form> 
</body>
</html>