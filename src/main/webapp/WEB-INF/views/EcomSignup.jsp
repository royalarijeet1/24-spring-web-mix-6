<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ecom Signup</h2>


<form action="esignup" method="post" enctype="multipart/form-data">

	FirstName : <input type="text" name="firstName"/><br><br> 
	Email : <input type="text" name="email"/><br><br> 
	Password : <input type="password" name="password"/><br><br> 
	Profile : <input type="file" name="profilePic"/> <br><Br> 
	<input type="submit" value="Signup"/>
</form>
</body>
</html>