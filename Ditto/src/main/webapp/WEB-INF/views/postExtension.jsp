<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
	.postField{
		width: auto;
		margin: 5px;
		
		background-color: #b9f6ca;
	}
	.postButton{
		color: window;
		background-color: #00e676;
		border-color #00e676;
		
		padding: 5px;
		box-shadow: 0 3px 6px 0 #fff, 0 -3px 6px 0 #fff;
	}
</style>

</head>
<body>

<%
String u_name = null,u_pass = null;
Cookie[] cooks = request.getCookies();
for(Cookie cook : cooks){
	if(cook.getName().toString().equals("u_name")){
		u_name = cook.getValue().toString();
		System.out.println("[postDeed] just got u_name "+u_name);
	}
	if(cook.getName().toString().equals("u_pass")){
		u_pass = cook.getValue().toString();
		System.out.println("[postDeed] just got u_pass "+u_pass);
	}
}

%>

<fieldset class="postField" >
	<form action="/Ditto/postDeed" method="post">
		What Silly you did today ?<br><br>
		<input type="text" value="<%=u_name %>" name="u_name" readonly="readonly" />
		<input type="password" value="<%=u_pass %>" name="u_pass" readonly="readonly" />
		<textarea style="width: 95%;" type="text" name="deed" placeHolder="Your silly deed here." ></textarea>
		<br><br><input class="postButton" type="submit" value="Post">
	</form>
</fieldset>

</body>
</html>