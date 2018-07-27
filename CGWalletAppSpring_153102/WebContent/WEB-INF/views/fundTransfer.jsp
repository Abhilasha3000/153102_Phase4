<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fund Transfer</title>
<style >
.error{

color:red;
font_weight:bold;
}
</style>
</head>
<body>

<div align="center">
<h2>Fund Transfer</h2>
<% if(session.getAttribute("no")==null)
response.sendRedirect("/CGWalletApp/");%>
<core:if test="${not empty message }"><font color="red">${message}</font></core:if>
<form:form action="ft" method="post" modelAttribute="customer" >
<table align="center">
<tr>
<td>Mobile no:</td>
<td><input name="mobileNo1" value=<%=session.getAttribute("no")%> readonly="readonly"/></td>
<td><form:errors name="mobileNo1" cssClass="error"/></td>

</tr>

<tr>
<td>Enter Target Mobile no:</td>
<td><input type="text" name="mobileNo2" /></td>
<td><form:errors type="text" name="mobileNo2" cssClass="error"/></td>
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