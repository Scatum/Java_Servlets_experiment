<%-- 
    Document   : home
    Created on : 09.08.2016, 17:59:32
    Author     : ScatUm
--%>

<%@page import="java.util.List"%>
<%@page import="domains.Project"%>
<%@page import="controllers.Factory"%>
<%@page import="domains.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ProjMana</title>
	<link rel="stylesheet" href="../css/userView.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
  <script src="../js/dataTable.js"></script>

</head>
<body>
      <div class = "start_page">
      	<h1><%=((User)request.getSession(false).getAttribute("user")).getU_name() %>! Welcome to ProjMan</h1>

<ul class="menu">
  <li>
      
      
      <select id="job" name="task_progres" >
              <option value="all_projects">All Project</option>
              <%
                  Factory f = Factory.getInstance();
                  List <Project> projects = f.getProjectDao().getProjects();
                for(int x=0; x<projects.size(); x++){
                    String selectOption = "<option value=" + projects.get(x).getId() ;
                   
                    selectOption+= ">" +projects.get(x).getName() + "</option>";
                    %>
                     <%= selectOption%>
                <%}%>
         
      
        </select>
      
      
        
        <li><a href="user-data-table">Show Projects</a></li>
  <li><a href="contact.asp">Developers</a></li>
  <li><a href="logout.jsp">Log Out</a></li>
</ul>



<table id="data-table" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Project</th>
                <th>Type</th>
                <th>Point</th>
                <th>Priority</th>
                <th>Description</th>
                <th>Date</th>
                <th>Assigned User</th>
                
            </tr>
        </thead>
        
        
    </table>




      </div>
        
    
      
    </body>
</html>
