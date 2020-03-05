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

<table border="2" class="table">
<tr>
<td>Subject</td><td>Content</td>
</tr>
<c:forEach items="${msglist}" var="msg">
    <tr >  
        <td> ${msg.subname}</td>
        <td>${msg.msgcontent}</td>
        <td>  <input type="hidden" id="idValue" value="${msg.id}" />view content</td>
        
    </tr>
</c:forEach>
</table>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	$(".table").on('click','tr',function(e){
		  e.preventDefault();
		  var $this = $(this);
		  var rowId = $this.find("idValue").val();
		 // var id = $(this).closest('tr').val();
		  alert(rowId);
		});
	
});
</script>
		
	
</html>