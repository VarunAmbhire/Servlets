<%@page import="com.techlabs.model.Contacts"%>
<%@page import="java.util.*"%>
<html>
	<head>
		<title>Contacts</title>
		
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		
	</head>
	
	<body class="container"> 
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <ul class="nav navbar-nav">
		    <li class="nav-item"><a href="Contacts">Contacts</a></li> &nbsp;&nbsp;
		    <li class="nav-item"><a href="AddContacts">Add</a></li>
		  </ul>
  </nav>
  
  <script type="text/javascript">
  function deleteMsg() {
	  if(confirm("Do u really want to Delete???")){
			return true;
	  }else{
		  return false;
	  }	
}
  
  </script>

		<table class="table">
			<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Email</td>
				<td>State</td>
				<td>Gender</td>
			</tr>
		<% 
		List<Contacts> contacts=(List)request.getAttribute("contactList");
		Iterator<Contacts> it=contacts.iterator();
		
		while(it.hasNext()){
			Contacts cont=(Contacts)it.next();
			out.println("<tr><td>"+cont.getId()+"</td><td>"+cont.getName()+"</td><td>"+cont.geteMail()+"</td><td>"+cont.getState()+"</td><td>"+cont.getGender()+
					"</td><td>"+
					"<form action=Edit method=get><input name=id value="+cont.getId()+" hidden>"+
					"<input class=btn btn-primary type=submit value=Edit></form>"
					+"</td><td>"+
					"<form action=Delete method=get onsubmit=>"+
					"<input name=id value="+cont.getId()+" hidden>"+
					"<input class=btn btn-primary type=submit value=Delete ></form>"
					+"</td><tr>");
		}
	%>
	</table>

	</body>
</html>