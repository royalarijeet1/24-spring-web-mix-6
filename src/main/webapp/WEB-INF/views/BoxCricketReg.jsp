<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Box Cricket Registration</h2>
	

	<form action="savereg" method="post">
		Name  : <input type="text" name="studentName" value="${reg.studentName}"/>
					<span style="color:red">${studentNameError}</span>
		<br><Br>
		
		Playing Type :  
						Batsman <input type="radio" name="playerType" value="Batsman"  ${reg.playerType!=null && reg.playerType.equals("Batsman") ? "checked" :"" }/>
						Bowler <input type="radio" name="playerType" value="Bowler" ${reg.playerType!=null && reg.playerType.equals("Bowler") ? "checked" : "" }/>
						All Rounder 	 <input type="radio" name="playerType" value="AllRounder" ${reg.playerType!=null && reg.playerType.equals("AllRounder") ? "checked" : "" }/>
						<span style="color:red">${playerTypeError}</span>
						<br><br> 
						
		Food Preference : 
					<select name="foodPreference">
						<option value="-1">---Select Your Food Preference---</option>
						<option value="Regular" ${reg.foodPreference!=null && reg.foodPreference.equals("Regular") ? "selected" :""}/> Regular
						<option value="Jain" ${reg.foodPreference!=null && reg.foodPreference.equals("Jain") ? "selected" :""}/>Jain
					</select>	
					<span style="color:red">${foodPreferenceError}</span>
					<br><br>
		Drink : 
				RB	<input type="checkbox" name="drink" value="rb" ${reg.drink!=null && reg.drink.contains("rb") ? "checked" :""}/> 
				MD<input type="checkbox" name="drink" value="md"  ${reg.drink!=null && reg.drink.contains("md") ? "checked" :""}/>
				TH<input type="checkbox" name="drink" value="th" ${reg.drink!=null && reg.drink.contains("th") ? "checked" :""}/>
				LJ<input type="checkbox" name="drink" value="lj" ${reg.drink!=null && reg.drink.contains("lj") ? "checked" :""}/>
				Co <input type="checkbox" name="drink" value="co" ${reg.drink!=null && reg.drink.contains("co") ? "checked" :""}/>
				<span style="color:red">${drinkPreferenceError}</span>
				<br><Br>
				<input type="submit" value="Register"/>

	</form>

</body>
</html>