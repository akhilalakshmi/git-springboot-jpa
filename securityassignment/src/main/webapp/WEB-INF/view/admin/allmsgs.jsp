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
  <a href="/user/success">Home</a>
<table border="2" class="table" id="theTable">
<tr>
<td>Subject</td>
</tr>
<c:forEach items="${msglist}" var="msg">
    <tr  id="${msg.id}"  onclick='trclick();'>  
        <td> ${msg.subname}</td>
   
        <td>  <input type="hidden" id="idValue" value="${msg.id}" />view content</td>
        
    </tr>
</c:forEach>
</table>

<div id="content"><jsp:include page="content.jsp"></jsp:include></div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
	  $('#theTable tr').click(function() {
		    	    
	       $.ajax({
	    	   url:'<%=request.getContextPath()%>/getContent',
      		 type : "GET",
       		data:{
       			msgid:this.id
    	         },
    	   success:function(response){
    		   $("#content").empty();
    		   $("#content").append(response);
    	   }
       
	  });
	});
});
</script>
		
	
</html>