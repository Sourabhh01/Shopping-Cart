<%@page import="com.jsp.Shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item to Cart</title>
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
        
        form {
            margin-top: 20px;
        }
        
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 12px 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }
        
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Add Item to Cart</h1>
        <% Product p = (Product) request.getAttribute("prodobj"); %>
        <form action="additemtocart">
        
        	<label for="id">ID:</label><br>
            <input type="hidden" name="id" id="id" value="<%=p.getId()%>" readonly><br>
        
			<label for="brand">Brand:</label><br>
            <input type="text" name="brand" id="brand" value="<%=p.getBrand()%>" readonly><br>
            
            <label for="model">Model:</label><br>
            <input type="text" name="model" id="model" value="<%=p.getModel()%>" readonly><br>
            
            <label for="category">Category:</label><br>
            <input type="text" name="category" id="category" value="<%=p.getCategory()%>" readonly><br>
            
            <label for="price">Price:</label><br>
            <input type="number" name="price" id="price" value="<%=p.getPrice()%>" readonly><br>
            
            <label for="quantity">Quantity:</label><br>
            <input type="number" name="quantity" id="quantity" required><br>
            
            <input type="submit" value="Add to Cart">
        </form>
    </div>
</body>
</html>
