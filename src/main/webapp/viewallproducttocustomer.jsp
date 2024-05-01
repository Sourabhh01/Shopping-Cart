<%@page import="com.jsp.Shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.Shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
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
        
        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #007bff;
            color: white;
        }
        
        tr:nth-child(even) {
            background-color: #f2f2f2;
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
<% List<Product> products = (List<Product>) request.getAttribute("productslist");%>
    <table cellpadding="20px" border="0">
        <tr>
            <th>Brand</th>
            <th>Category</th>
            <th>Model</th>
            <th>Price</th>
            <th>Add to Cart</th>
        </tr>
        <%
            for (Product p : products) {
        %>
        <tr>
            <td><%= p.getBrand() %></td>
            <td><%= p.getCategory() %></td>
            <td><%= p.getModel() %></td>
            <td><%= p.getPrice() %></td>
            <td><a href="additem?id=<%= p.getId() %>">ADD</a></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
