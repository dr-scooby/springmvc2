<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot MVC</title>
</head>
<body>
<h1>Welcome to home page, Jah. Spring Boot MVC.</h1>

<form action="add">
	Enter 1st number : <input type="text" name="num1"><br>
	Enter 2nd number : <input type="text" name="num2"><br>
	<input type="submit">
</form>

<br>
<br>
<h2>Enter Alien info:</h2>
<form action="addAlien">
	Enter Alien ID : <input type="text" name="aid"><br>
	Enter Alien Name : <input type="text" name="name"><br>
	<input type="submit">
</form>
</body>
</html>