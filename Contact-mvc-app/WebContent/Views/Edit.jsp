<%@page import="com.techlabs.model.StateService"%>
<%@page import="com.techlabs.model.ContactService"%>
<%@page import="com.techlabs.model.Contacts"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit</title>
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
		String id=request.getParameter("id");
		System.out.println(id);
		Contacts contacts=ContactService.getInstance().getById(id);
		String stateList[]=new StateService().getStates();
		String name=contacts.getName();
		String email=contacts.geteMail();
		String gender=contacts.getGender();
		String state=contacts.getState();
		String check1="",check2="";
		if(gender.equals("male")){
			check1="checked";
		}else{
			check2="checked";
		}
	
		
	%>
	
	<form class="form-group" action="/Contact-mvc-app/Edit" method="post">
		Id : <label class="form-control" ><%=id%></label>
		<input name="editId" value="<%=id %>" hidden> <br>
		Name :<input class="form-control" type="text" name="editName" value="<%=name%>"><br>
		Email:<input class="form-control" type="email" name="editEmail" value="<%=email%>"><br>
		State:<select name="editState" class="form-control" size="1" >
				<%for(int i=0;i<stateList.length;i++){
					String select[]=new String[stateList.length];
					if(state.equals(stateList[i])){
						select[i]="selected";
					}
					%><option value="<%=stateList[i]%>" <%=select[i]%>><%=stateList[i]%></option><%	
					}
				%>			  
			  </select><br>
		
		Gender:&nbsp;&nbsp;<input type="radio" name="editGender" value="male" <%=check1 %>>Male&nbsp;&nbsp; 
		<input type="radio" name="editGender" value="female" <%=check2 %>>Female<br><br>
		
		<input type="submit" class="btn btn-default" value="Update">
	</form>
</body>
</html>