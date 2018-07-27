<%@page import="javassist.expr.NewArray"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Print Transaction</title>
</head>
<body>



<table border="1">

<tr><th>Transaction ID</th><th>Mobile No</th><th>Transaction Date</th><th>Transaction Type</th><th>Transaction Amount</th><th>Transaction Status</th> </tr>
  <core:forEach items="${transaction}" var="transaction1" >
  
  
 
    <tr>    
     <td><core:out value="${transaction1.transaction_Id}" /></td>    
      <td><core:out value="${transaction1.mobileNo}" /></td>
      <td><core:out value="${transaction1.transactionDate}"/></td>
       <td><core:out value="${transaction1.transaction_type}"/></td>
        <td><core:out value="${transaction1.transaction_amount}" /></td>
         <td><core:out value="${transaction1.transaction_status}"/></td>
        
    </tr>
  
    
  </core:forEach>
</table>
<div align="right"><a href="logout">Logout</a></div><br>
<div align="right"><a href="menu">Menu</a></div>

</body>
</html>