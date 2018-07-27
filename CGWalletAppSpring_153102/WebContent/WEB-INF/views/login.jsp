<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>

<body>

<%session.setAttribute("no", request.getParameter("mobno"));  %>

<br><br><a href="showBalance">Show Balance</a>
<br><br><a href="deposit">Deposit</a>
<br><br><a href="withdraw">Withdraw</a>
<br><br><a href="fundTransfer">FundTransfer</a>
<br><br><a href="printTransaction">Print Transaction</a>
</html>