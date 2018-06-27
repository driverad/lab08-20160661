<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Access</title>


<style>
	/*
	Color fondo: #632432;
	Color header: 246355;
	Color borde: 0F362D;
	Color iluminado: 369681;
*/
body{
	background-color: #246355;
	font-family: Arial;
}

#main-container{

	width: 1200px;
	margin: 0 auto;
	
}

table{
	background-color: white;
	text-align: left;
	border-collapse: collapse;
	width: 100%;
	
}

th, td{
	padding: 8px;
}

thead{
	background-color: #638060;
	border-bottom: solid 5px #0F362D;
	color: white;
}

tr:nth-child(even){
	background-color: #ddd;
}

tr:hover td{
	background-color: #369681;
	color: white;
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
	<%@ page import="java.util.List"%>
	<%@ page import="model.entity.Acces"%>

	
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
		<li><a href="/access/add" />Create a new Acces</a></li>
			
				
			
		</ul>
	</div>
	
	
	
	<%
		List<Acces> access = (List<Acces>) request.getAttribute("access");
	%>
	<%if (access.size() > 0) {%>
		
		<div id="main-container">
		
		<table align="right">
		<thead>
            <tr >
                <th>ID</th>
                <th>Role</th>
                <th>Resource</th>
                <th>Status</th>
                <th>Created</th>
                <th>Actions</th>
            </tr>
        </thead>
	<%for (int i = 0; i <access.size(); i++) {%>
		<%Acces g= (Acces)access.get(i) ; %>
        
        <tbody>
            
            
            <tr>
                <td><%=g.getId()%></td>                          
                <td><%=g.getRole()%></td>
                <td><%=g.getResource()%></td>
                <td><%=g.isStatus()%></td>
                <td><%=g.getCreated()%></td>
                <td class="actions">
                    <a href="/access/view?id=<%=g.getId()%>">View</a>
                	<a href="/access/edit?id=<%=g.getId()%>">Edit</a>
                	<form name="post_<%=g.getId() %>" style="display:none;" method="post" action="/access/delete"><input type="hidden" name="id" value="<%=g.getId() %>"/></form><a href="#" onclick="if (confirm(&quot;Are you sure you want to delete # <%=g.getId() %>?&quot;)) { document.post_<%=g.getId() %>.submit(); } event.returnValue = false; return false;">Delete</a>                    
                </td>
            </tr>
            
        </tbody>
    
		
		<%} %>
		
		</table>
		
		</div>
		
		
	<%} %>
	
	

</body>
</html>