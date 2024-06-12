<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your Details</h2>
StudentName: ${reg.getStudentName() }  <br>
PlayerType : ${reg.getPlayerType() }  <br>
FoodPreference :  ${reg.getFoodPreference() }  <br>
Drinks : ${reg.getDrink() } <br>
</body>
</html>