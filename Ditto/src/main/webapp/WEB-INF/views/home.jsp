<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.project.Ditto.Services.UsersService"%>
<%@page import="org.project.Ditto.Services.DeedService"%>
<%@page import="org.project.Ditto.Models.Dto_Users"%>
<%@page import="org.project.Ditto.Models.Deeds"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Ditto - What you did silly today?</title>
</head>
<style type="text/css">
/* disabling color change in ancho texts.. */
	a {
	text-decoration: none !important;
	color:#FFF;}      /* unvisited link */
a:visited {color:#FFF;}  /* visited link */
a:hover {color:#FFF;}  /* mouse over link */
a:active {color:#FFF;}

/* postField customizations */
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
	
	/* NavBar Customizations */

.bar{
	position: fixed;
	 
	width: 100%;
	height: 45px;
	overflow: hidden;
	color : window;
	text-indent: 50px;
	font-size : xx-large;
	background-color: #00695c;
	transition: all 0.3s ease 0s;
	
}


.bar:hover{
	text-indent: 150px;
}
/*  Deed Tiles Customizations */
.tile {
	
	  width: 98.5%;
  	height : 105px;
	display: inline-block;
	box-sizing: border-box;
	background: #fff;
	padding-left: 25px;
	padding-right: 25px;
	padding-top: 5px;
	padding-bottom: 5px;
	opacity: 0.8;
	
	margin: 10px;
 	transition: all 0.2s ease 0s;
 	overflow: hidden;
}

.down{
	margin-bottom: -15px;
	
}
.title{
	height : 75px;
	margin-top: 0px;
	margin-bottom: 2px;
	overflow: auto;
}
.tile:hover{opacity: 1;
	height : 130px;
	color: #fff;
}

 .green {
    color: #000;
			 }


  .green {
    background: #00c853;

  }
	.green:hover {
		box-shadow: 0 3px 6px 0 #bdbdbd, 0 -3px 6px 0 #bdbdbd;

	}
	
</style>

<body style="margin : 0px;">
<div class="bar"><a href="/Ditto">Ditto</a>
	
<% 	Dto_Users user =(Dto_Users) request.getAttribute("user");
	// looking for any available loginned users..
	if(user != null ){
	System.out.println("[home] got user");

	%><div style="float: right; font-size:x-large; padding-right: 50px; padding-top: 5px;" >
	<a href="/Ditto/logoutUser">Logout</a>
	</div>
</div>
<br /><br /><br />
		<fieldset class="postField" >
	<form action="/Ditto/postDeed" method="post">
		What Silly you did today ?<br><br>
		<input type="text" value="<%=user.getU_name() %>" name="u_name" readonly="readonly" />
		<input type="password" value="<%=user.getU_pass() %>" name="u_pass" readonly="readonly" />
		<textarea style="width: 95%;" type="text" name="deed" placeHolder="Your silly deed here." ></textarea>
		<br><br><input class="postButton" type="submit" value="Post">
	</form>
	
</fieldset>
<%}
	else if(request.getAttribute("signupToken") != null){%>
		
</div>
<br /><br /><br />
		<%@ include file="signupExtension.jsp" %>
	<%}
	
	else{%><div style="float: right; font-size:x-large; padding-right: 50px; padding-top: 5px;" >
	<a href="/Ditto/signUpUser">SignUp</a>	
	</div>
</div>
<br /><br /><br />
		<%@ include file="loginExtension.jsp" %>
<%}

	
	// loading the deeds list from the Database here...
List<Deeds> deedList = (List<Deeds>)request.getAttribute("deedList");
if(deedList != null){
for(Deeds deed : deedList){	%>
	<div class="tile green">
	<h3 class="title"><%=deed.getD_deed() %> </h3>
	<div class="down">by :<%=deed.getD_user_name() %></div> 	
	<br><% if(user != null){%>
	<a href="/Ditto/dittoMe?d_id=<%=deed.getD_id() %>&u_name=<%=user.getU_name() %>">
	Ditto Me</a><%} %>  <div style="float: right;">Dittos : <%=deed.getD_ditto_count() %></div>
</div>
<%	}
}%>

</body>
</html>
