<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECOM SIGNUP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<h2>Ecom Signup</h2>
			
			
			<form action="esignup" method="post" enctype="multipart/form-data">
				<div class="form-group">
					FirstName : <input type="text" name="firstName" class="form-control"/><br><br> 
				</div>
				<div class="form-group">
					Email : <input type="text" name="email" class="form-control"/><br><br> 
				</div>
				<div class="form-group">
					Password : <input type="password" name="password" class="form-control"/><br><br> 
				</div>
				<div class="form-group">
					Profile : <input type="file" name="profilePic" class="form-control"/> <br><Br> 
				</div>
				<input type="submit" value="Signup" class="btn btn-success"/>
			</form>
		</div>
	</div>
</div>
</body>
</html>