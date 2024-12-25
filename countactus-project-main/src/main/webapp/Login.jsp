<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
<style>
span {
color: rgb(250, 30, 30);
font-weight: bold;
}
.form {
    border: 1px solid black;
    height: 300px;
    width: 400px;
    margin: 100px auto;
    border-radius: 10px;
}

header {
    background-color: #d2d0d0; 
    padding: 10px;
    border-radius: 10px 10px 0px 0px;
    text-align: center;
}

label {
    margin: 10px auto;
    padding: 10px;
}
.body{
    padding-left: 30px;
}
input[type="text"],input[type="password"], textarea {
    width: 90%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    box-sizing: border-box;
    margin: 1%;
}

input[type="submit"] {
    background-color: #a8ada9; 
    color: white;
    padding: 10px 20px;
    border: none;
    margin-left:40%;
    border-radius: 3px;
}
</style>
</head>
<body>
<div class="form">
<form action="login" method="post">
<header>
<h2>Admin Login</h2>
</header>
<div class="body">
<br><label>User Name<span>*</span></label><br>
<input type="text" name="name" required><br>
<label>Password<span>*</span></label><br>
<input type="password" name="password" required><br>
</div>
<input type="submit" value="Login">
</form>
</div>
</body>
</html>