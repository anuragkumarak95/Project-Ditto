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

  .purple, .blue, .red, .orange, .green {
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
<div class="bar">Ditto
	<div style="float: right; font-size:x-large; padding-right: 50px; padding-top: 5px;" >SignUp</div>
</div>

<%-- <h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P> --%>

<br /><br /><br />
<% 	Dto_Users user =(Dto_Users) request.getAttribute("user");
		
	if(user != null){
	System.out.println("[home] got user");
	Cookie userCookie = new Cookie("u_name",user.getU_name());
	response.addCookie(userCookie);
	userCookie = new Cookie("u_pass",user.getU_pass());
	response.addCookie(userCookie);
	%>
		<%@ include file="postExtension.jsp" %>	
<%} else{%>
		<%@ include file="loginExtension.jsp" %>
<%}%>

<%-- <%Deeds freshDeed = (Deeds)request.getAttribute("deed");
	if(freshDeed != null){
		System.out.println("got some deed here, "+freshDeed.getD_deed());
		Cookie[] cookies =  request.getCookies();
		String u_name=null,u_pass=null;
		for(Cookie cook : cookies){
			if(cook.getName().toString().equals("u_name")){
				u_name = cook.getValue().toString();
				System.out.println("got name here, "+u_name);
			}
			else if(cook.getName().toString().equals("u_pass")){
				u_pass = cook.getValue().toString();
				System.out.println("got pass here, "+u_pass);
			}
		}
		if(u_name != null && u_pass != null){
			UsersService servu = new UsersService();
			Dto_Users freshU = servu.getUser(u_name, u_pass);
			System.out.println("freshU id here :"+freshU.getU_id());
			DeedService servd = new DeedService();
			servd.linkDeed(freshDeed.getD_id(), freshU.getU_id());
			System.out.println("deed link successfull..");
		}
		
	}
%> --%>

<%
List<Deeds> deedList = (List<Deeds>)request.getAttribute("deedList");
if(deedList != null){
for(Deeds deed : deedList){
	System.out.println("[home-deed] ids "+deed.getD_user_id());
	 Dto_Users deed_user = (Dto_Users) new UsersService().getUserById(deed.getD_user_id()); 
	 
	%>
	<div class="tile green">
	<h3 class="title"><%=deed.getD_deed() %> </h3>
	<div class="down">by : <%=deed_user.getU_name() %></div> 	
	<br>aur kya??
</div>
	<% 
}
}
%>


</body>
</html>
