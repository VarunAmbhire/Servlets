<%@page import="com.techlabs.model.StateService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.techlabs.model.Contacts"%>
<%@page import="java.util.*"%>
<html>
		<head>
		<title>Add Contact Form</title>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		</head>
<body class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="nav navbar-nav">
				<span class="nav-item"><a href="/Contact-mvc-app/Contacts">Contacts</a></span>&nbsp;&nbsp;
				<span class="nav-item"><a href="/Contact-mvc-app/AddContacts">Add</a></span>
			</div>
	</nav>
	
	<% 
		UUID uid = UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d");
		String id=uid.randomUUID().toString();
		String name,email;
		Contacts contact=(Contacts)request.getAttribute("contact");
		String errorMessage=(String)request.getAttribute("errMsg");
		String[] stateList=new StateService().getStates();
		if(contact==null){
			name="";
			email="";
		}else{
			name=contact.getName();
			email=contact.geteMail();
		}
		

	
	%>

	<form class="form-group" action="/Contact-mvc-app/AddContacts" method="post">
		Id : <label class="form-control" ><%=id%></label>
		<input name="contactId" value="<%=id %>" hidden> <br>
		Name :<input class="form-control" type="text" name="contactName" value="<%=name%>"><br>
		Email:<input class="form-control" type="email" name="contactEmail" value="<%=email%>"><br>
		
		State:<select name="contactState" class="form-control" size="1">
				<%for(int i=0;i<stateList.length;i++){
					%><option value="<%=stateList[i]%>"><%=stateList[i]%></option><%	
					}
				%>			  
			  </select><br>
		
		Gender:&nbsp;&nbsp;<input type="radio" name="contactGender" value="male">Male&nbsp;&nbsp; 
		<input type="radio" name="contactGender" value="female">Female<br><br>
		
		<input type="submit" class="btn btn-default" value="Add">
	</form>

		<h3 class="text-danger"><%=errorMessage %></h3>
	
</body>
</html>