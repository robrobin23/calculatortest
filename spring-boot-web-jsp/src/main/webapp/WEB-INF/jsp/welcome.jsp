<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<%@ page import="com.calculator.WelcomeController" %>
<%@ page import="java.util.ArrayList" %>
<script type="text/javascript">



</script>
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
    WelcomeController welcomeController= new WelcomeController();
	
	ArrayList<String> termTypeArrayList = new ArrayList<String>();
	ArrayList<String> termTypeArrayList2 = new ArrayList<String>();
	termTypeArrayList= welcomeController.getTermType(termTypeArrayList2);
	
	ArrayList<String> locationArrayList = new ArrayList<String>();
	ArrayList<String> locationArrayList2 = new ArrayList<String>();
	locationArrayList= welcomeController.getLocation(locationArrayList2);
	
	ArrayList<String> InstanceTypeArrayList = new ArrayList<String>();
	ArrayList<String> InstanceTypeArrayList2 = new ArrayList<String>();
	InstanceTypeArrayList= welcomeController.getInstanceType(InstanceTypeArrayList2);
	
%>
    
	<div class="container">

		<div class="starter-template">
			<h1>Price Calculator</h1>
		</div>
		
		<form action = "/result" id = "result" method = "POST">
		<div >
			<table>
				<tr>
					<td>
						<tr>
							<h2>TermType</h2>					
						</tr>
						<tr>
							<select name="termtype" id="termtype">
            				<option>Select Term Type</option>
            				<% for (int i = 0 ; i < termTypeArrayList.size(); i++) { %>
            				<option value="<%=termTypeArrayList.get(i) %>"><%=termTypeArrayList.get(i) %></option>
            				<% } %>
        					</select>
        				</tr>
					</td> 
  
					<td>
						<tr>
							<h2>Location</h2>	
						</tr>
						<tr>
							<select name="Location" id="Location">
            				<option>Select Location</option>
            				<% for (int i = 0 ; i < locationArrayList.size(); i++) { %>
            				<option value="<%=locationArrayList.get(i) %>"><%=locationArrayList.get(i) %></option>
            				<% } %>
        					</select>
        				</tr>
					</td>   
					<td>
						<tr>
							<h2>InstanceType</h2>					
						</tr>
						<tr>
							<select name="InstanceType" id="InstanceType">
            				<option>Select InstanceType</option>
            				<% for (int i = 0 ; i < InstanceTypeArrayList.size(); i++) { %>
            				<option value="<%=InstanceTypeArrayList.get(i) %>"><%=InstanceTypeArrayList.get(i) %></option>
            				<% } %>
        					</select>
        				</tr>
					</td>
					<td>
						<tr>
							<h2>Quantity</h2>					
						</tr>
						<tr>
							<select name="Quantity" id="Quantity">
            				<option>Select Quantity</option>
            				<% for (int i = 1 ; i < 11; i++) { %>
            				<option value="<%=i %>"><%=i %></option>
            				<% } %>
        					</select>
        				</tr>
					</td>
					 			
        		<tr>
        	</table>
        </div>
        <div>
        	<input type="submit" value="calculate" />
        </div>
      </form>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
