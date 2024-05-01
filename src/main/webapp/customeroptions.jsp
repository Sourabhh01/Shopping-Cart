<%@page import="com.jsp.Shoppingcart.dto.Customer"%>
<%@page import="com.jsp.Shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .container {
            text-align: center;
            background-color: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        
        h1 {
            color: #333;
            margin-bottom: 20px;
            font-size: 24px;
        }
        
        p {
            margin-bottom: 20px;
            color: #888;
            font-size: 16px;
        }
        
        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            transition: color 0.3s ease;
        }
        
        a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body> 
<% Customer c = (Customer) session.getAttribute("customerinfo"); %>
<% if(c!=null) { %>
    <div class="container">
        <h1 style="color:green;">${msg}</h1>
        <h1>
        <a href="displayproducts"> DISPLAY ALL PRODUCTS</a>
        </h1>
         <h1>
        <a href="readbrand.jsp">DISPLAY BY BRAND</a>
        </h1>
         <h1>
        <a href="readcategory.jsp">DISPLAY BY CATEGORY</a>
        </h1>
        <a href="readmodel.jsp">DISPLAY BY MODEL</a>
        </h1>
    </div>
    <%}
    else {%>
    <h1> <a href="customerloginform.jsp"> Login Here First </a> </h1>
    
    <% } %>
</body>
</html>