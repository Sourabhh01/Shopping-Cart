<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
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
        <h1>Add Product</h1>
        <form:form action="saveproduct" modelAttribute="productobj">
            <label for="brand">Enter Brand:</label><br>
            <form:input path="brand"/> <br>
            
            <label for="model">Enter Model:</label><br>
            <form:input path="model"/> <br>
            
            <label for="category">Enter Category:</label><br>
             <form:input path="category"/> <br>
            
            <label for="price">Enter Price:</label><br>
            <form:input path="price"/> <br>
            
            <label for="stock">Enter Stock:</label><br>
            <form:input path="stock"/> <br>
            
            <input type="submit" value="Add Product">
        </form:form>
    </div>
</body>
</html>
