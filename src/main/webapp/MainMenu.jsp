
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .btn {
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
            text-decoration: none;
        }

        .btn-primary {
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .app-image {
            width: 80%;
            max-width: 600px;
            margin-top: 20px;
        }

        .buttons {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to Our Shopping Website</h1>
    <h2>${message}</h2>
    <img src="./resources/Images/Mainmenu.png" alt="Shopping Web Application" class="app-image">
    <div class="buttons">
        <a href="MenuMerchant.jsp" class="btn btn-primary">Explore as a Merchant <i class="fas fa-store"></i></a>
        <a href="CustomerMenu.jsp" class="btn btn-primary">Explore as a Customer <i class="fas fa-users"></i></a>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
</body>
</html>
