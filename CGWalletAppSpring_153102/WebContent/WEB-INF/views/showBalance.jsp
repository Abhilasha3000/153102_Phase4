<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Balance</title>
<style >
.error{

color:red;
font_weight:bold;
}
</style>
</head>
<body>
<div align="center">
<h2>Show Balance</h2>
<% if(session.getAttribute("no")==null)
response.sendRedirect("/CGWalletApp/");%>
<form:form action="show" method="post" modelAttribute="customer">
<td>Mobile no:</td>
<td><input name="mobileNo" value=<%=session.getAttribute("no")%> readonly="readonly"/></td>
<td><form:errors name="mobileNo" cssClass="error"/></td>
<input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>