<html>
<head>
<%@ page import="java.util.List"%>
	<%@ page import="model.entity.Guest"%>
			<% Guest g =(Guest)request.getAttribute("guests");%>
	
<title><%=g.getId()%></title>


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







<script>
	function validar() {
		if (document.miFormulario.name.value == ''
				|| document.miFormulario.city.value == ''
				|| document.miFormulario.phone.value == ''
				|| document.miFormulario.age.value == ''
				|| document.miFormulario.email.value == ''
				|| document.miFormulario.dni.value == '') {

			alert("Complete the form.");
			return false;
		} else if (isNaN(document.miFormulario.phone.value)) {
			alert("The phone entered is not valid.");
			return false;
		} else if (isNaN(document.miFormulario.dni.value)) {
			alert("The dni entered is not valid.");
			return false;
		} else if (isNaN(document.miFormulario.age.value)) {
			alert("The age entered is not valid.");
			return false;
		} else if (document.miFormulario.age.value <= 0) {
			alert("You can't enter a age less than or equal to 0.");
			return false;
		}
		//Test correo

		else if (!(/\S+@\S+\.\S+/.test(document.miFormulario.email.value))) {
			alert("Enter a valid email");
			return false;
		}

		else if (/^[A-Za-z][A-Za-z]*/.test(document.miFormulario.name.value) == false) {
			alert("The name entered is not valid.");
			return false;
		}
		else if (/^[A-Za-z][A-Za-z]*/.test(document.miFormulario.city.value) == false) {
			alert("The city entered is not valid.");
			return false;
		}


	}
</script>



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
		<li><a href="/guests">Back</a></li>
			
				
			
		</ul>
	</div>
	
		<div class="formulario">
	
		<h2><%=g.getName()%>/<%=g.getId()%></h2>
		
	<form name="miFormulario" method="get" action="/guests/update"
		onsubmit="return validar();">
		<input type="hidden" name="action" value="guestCreatedDo" />
		
		<p>Name:</p>
			<input type="text" name="name"value=<%=g.getName()%> >
		
			<p>ID:</p>
			<input type="text" name="id2"value=<%=g.getId()%> readonly="readonly" >
					
			<p>City:</p>
			<input type="text" name="city" value=<%=g.getCity()%>>
			<p>Phone:</p>
			<input type="text" name="phone"value=<%=g.getPhone()%>>
			<p>Age:</p>
			<input type="text" name="age"value=<%=g.getAge()%>>
			<p>E-mail:</p>
			<input type="text" name="email"value=<%=g.getEmail()%>>
				
	
			<p>Gender:</p>
						
				<% if(g.isGender()){ %>
				<select name="gender">
				<option value="hombre" selected="selected">Male</option>
				<option value="mujer">Female</option>
			</select>				
				<%}else{ %>
			<select name="gender">
				<option value="hombre" >Male</option>
				<option value="mujer" selected="selected">Female</option>
			</select>				
				<%}%>
				
				
			 <p>DNI:</p>
			<input type="text" name="dni"value=<%=g.getDni()%> >
			 
			 <p>Status</p>
			 
			 <% if(g.isStatus()){ %>
				<select name="guestStatus">
				<option value="true" selected="selected">True</option>
				<option value="false">False</option>
			</select>				
				<%}else{ %>
				<select name="guestStatus">
				<option value="true" >True</option>
				<option value="false"selected="selected">False</option>
			</select>
				<%}%>
			 
		<input type="submit" onclick="if (confirm(&quot;Are you sure you want to edit # <%=g.getId() %>?&quot;)) { document.post_<%=g.getId() %>.submit(); } event.returnValue = false; return false;" value="Save">
		

	</form>
	
	</div>

			
			
			
			
		
</body>
</html>