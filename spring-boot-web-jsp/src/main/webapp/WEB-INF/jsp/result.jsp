<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@ page import="com.calculator.ResultController" %>
<%@ page import="java.util.ArrayList" %>

<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<%
    /*podemos utilizar todas las cases que hallamos importado*/
    ResultController resultController= new ResultController();
	

	
%>
    
	<div class="container">

		<div class="starter-template">
			<h1>Price Calculator</h1>
		</div>
		
		<div >
			<table>
				<tr>
					<li><p><b>Term Type:</b>
   						<%= request.getParameter("termtype")%>
					</p></li>					 			
        		<tr>
        		<tr>
					<li><p><b>Location:</b>
   						<%= request.getParameter("Location")%>
					</p></li>					 			
        		<tr>
        		<tr>
					<li><p><b>InstanceType:</b>
   						<%= request.getParameter("InstanceType")%>
					</p></li>					 			
        		<tr>
        		<tr>
					<li><p><b>Quantity:</b>
   						<%= request.getParameter("Quantity")%>
					</p></li>					 			
        		<tr>
        		<tr>
					<li><p><b>Total:</b>
   						<%=resultController.getTotal(request.getParameter("termtype"),request.getParameter("Location"),request.getParameter("InstanceType"),request.getParameter("Quantity"))%>
				</p></li>					 			
        		<tr>
        		
        	</table>
        	
		<form action = "/" id = "result" method = "POST">
		
        <div>
        	<input type="submit" value="return" />
        </div>
      </form>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
