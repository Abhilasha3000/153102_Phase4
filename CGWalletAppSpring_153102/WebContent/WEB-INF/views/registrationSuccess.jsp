<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<div align="center">
<h2 style="color:blue">Account created successfully</h2>
<h2>Welcome ${customer.name}</h2><br>
<h2>Mobile No ${customer.mobileNo}</h2>
<h2>Wallet ${customer.wallet}</h2>

</div>
<div align="right"><a href="/CGWalletApp/">Login</a></div>
</body>
</html>