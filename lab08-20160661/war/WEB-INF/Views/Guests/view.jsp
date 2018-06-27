<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Guest</title>


<style>
p {
	color: black;
	font-family: Verdana;
}

body {
    align:right;
	background-color: #246355;
	font-family: Arial;
	
	box-sizing: border-box;
	background-size: cover;
}

h2 {
	color: white;
}

.formulario {
	margin: 0 auto;
	width: 420px;
	heigth: 100px;
	background: rgba(0, 0, 0, .5);
	padding: 10px;
	color: #999;
}

input {
	border-radius: 2px;
	padding: 10px;
	width: 400px;
	background: rgba(0, 0, 0, .5);
	color: white;
	border:none;
	
}

#menu{
			background-color: #000;
		}
		#menu ul{
			list-style: none;
			margin: 0;
			padding: 0;
		}
		#menu ul li{
			display: inline-block;
		}
		#menu ul li a{
			color: white;
			display: block;
			padding: 20px 20px;
			text-decoration: none;
		}
		#menu ul li a:hover{
			background-color: #42B881;
		}
		.item-r{
			float: right;
		}
#menu2{
			background-color: #000;
						float: center;
						widght:19px;
			
			
		}
		#menu2 ul{
			list-style: none;
			margin: 0;
			padding: 0;
		
		}
		#menu2 ul li{
			display: block;
			
		}
		#menu2 ul li a{
			color: white;
			display: block;
			padding: 10px 20px;
			text-decoration: none;
			
		}
		#menu2 ul li a:hover{
			background-color: #42B881;
			
		}
		 .item-r{
			float: right;
		}


</style>






</head>
<body>

<div id="menu">
		<ul>
			<li><a href="/guests">GUESTS</a></li>
			<li><a href="/users">Users</a></li>
			<li><a href="/roles">Roles</a></li>
			<li><a href="/resources">Resources</a></li>
			<li><a href="/access">Acces</a></li>
			
			<li class="item-r"><a href="#">Logout</a></li>
			
		</ul>
	</div>
	
	<div id="menu2">
		<ul>
		<li><a href="/guests" />Back</a></li>
			
				
			
		</ul>
	</div>



	<%@ page import="java.util.List"%>
	<%@ page import="model.entity.Guest"%>


	<% Guest g =(Guest)request.getAttribute("guest");%>
	
	
	
	<div class="formulario">
		<h2>Guest: <%=g.getName()%></h2>

	
	<form name="miFormulario" method="get" action="/guests/add"
		onsubmit="return validar();">
		<input type="hidden" name="action" value="guestCreatedDo" />
		
		
		
			<p>ID:</p>
			<input type="text" name="email"value=<%=g.getId()%> readonly="readonly">
					
			<p>City:</p>
			<input type="text" name="city" value=<%=g.getCity()%> readonly="readonly">
			<p>Phone:</p>
			<input type="text" name="phone"value=<%=g.getPhone()%> readonly="readonly">
			<p>Age:</p>
			<input type="text" name="age"value=<%=g.getAge()%> readonly="readonly">
			<p>E-mail:</p>
			<input type="text" name="email"value=<%=g.getEmail()%> readonly="readonly">
				
	
			<p>Gender:</p>
						
				<% if(g.isGender()){ %>
				<input type="text" value=Male readonly="readonly">
				
				<%}else{ %>
				<input type="text" value=Female readonly="readonly">
				
				<%}%>
				
				
			 <p>DNI:</p>
			<input type="text" name="dni"value=<%=g.getDni()%> readonly="readonly">
			 
			 <p>Status</p>
			 
			 <% if(g.isStatus()){ %>
				<input type="text" value=True readonly="readonly">
				
				<%}else{ %>
				<input type="text"value=False readonly="readonly">
				
				<%}%>
			 
		

	</form>
	</div>


</body>
</html>