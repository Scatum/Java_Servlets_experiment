<%@ page import="domains.User" %><%--
    Document   : index
    Created on : 08.08.2016, 20:54:48
    Author     : ScatUm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ProjMana</title>
	<link rel="stylesheet" href="css/aut.css">
</head>
<body>

<%

    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Expires","0");
    response.setDateHeader("Expires",-1);

if(request.getSession(false).getAttribute("user") != null){
    User user = (User)request.getSession(false).getAttribute("user");
    request.getRequestDispatcher("home").forward(request, response);
}
%>
      <div class = "start_page">
      	<h1>Welcome to ProjMan</h1>
         <form action="home" method="post">
        
        <fieldset>
          
          <label for="mail">Email:</label>
          <input type="email" id="mail" name="user_email">
          <label for="password">Password:</label>
          <input type="password" id="password" name="user_password">

         
        </fieldset>
        <button type="submit">Log In</button>
      </form>

        <a href="signup.jsp" class = "start_btn">Sign Up</a>
      </div>
        
    
      
    </body>
</html>
