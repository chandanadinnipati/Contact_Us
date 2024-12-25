<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<style>
span {
color: rgb(250, 30, 30);
font-weight: bold;
}
.form {
    border: 1px solid black;
    height: 500px;
    width: 500px;
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
input[type="text"],input[type="email"], textarea {
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
<form action="save" method="post">
<header>
<h2>Contact Us</h2>
<p>please fill the form in decent manner</p>
</header>
<div class="body">
<br><label>Full Name<span>*</span></label><br>
<input type="text" name="uname" required><br>
<label>E-Mail<span>*</span></label><br>
<input type="email" name="email" placeholder="example@example.com" required><br>
<label>Message<span>*</span></label><br>
<textarea name="message" rows=5 cols=40 required></textarea><br>
</div>
<input type="submit">
</form>
</div>
</body>
</html>