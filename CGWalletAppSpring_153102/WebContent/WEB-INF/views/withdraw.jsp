<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw</title>
<style >
.error{

color:red;
font_weight:bold;
}
</style>
</head>
<body>
<core:if test="${not empty message }"><font color="red">${message}</font></core:if>
<div align="center">
<h2>Withdraw</h2>
<% if(session.getAttribute("no")==null)
response.sendRedirect("/CGWalletApp/");%>
<form:form action="with" method="post" modelAttribute="customer">
<table align="center">
<tr>
<td>Mobile no:</td>
<td><input name="mobileNo" value=<%=session.getAttribute("no")%> readonly="readonly"/></td>
<td><form:errors name="mobileNo" cssClass="error"/></td>
</tr>

<tr>
<td>Enter amount to withdraw:</td>
<td><form:input path="wallet.balance" size="30"/></td>
<td><form:errors path="wallet.balance" cssClass="error"/></td>
</tr>

<tr>
<td><input type="submit" value="Submit"/></td>
</tr>
</table>
</form:form>
</div>

</body>
</html>