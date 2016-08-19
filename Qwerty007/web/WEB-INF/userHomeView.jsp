<%-- 
    Document   : home
    Created on : 09.08.2016, 17:59:32
    Author     : ScatUm
--%>

<%@page import="java.util.List" %>
<%@page import="domains.Project" %>
<%@page import="controllers.Factory" %>
<%@page import="domains.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
<%
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Expires", "0");
    response.setDateHeader("Expires", -1);
%>

<div class="start_page">
    <h1 class="user-name"><%=((User) request.getSession(false).getAttribute("user")).getU_name() %></h1><h1>! Welcome to ProjMan</h1>

    <ul class="menu">
        <li>
            <select id="content-select" name="content-selec">
                <option value="all_tasks">All Tasks</option>
                <option value="all_projects">All Projects</option>

            </select>
        </li>
        <li><a href="logout.jsp">Log Out</a></li>
    </ul>

<div class="table-content" id="tasks-area">
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

    <div class="table-content" id="projects-area">
        <table id="data-table-projects" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>To Do</th>
                <th>On Hold</th>
                <th>In Progres</th>
                <th>In Review</th>
                <th>Done</th>
                <th>Toatal</th>

            </tr>
            </thead>


        </table>
    </div>



</div>


</body>
</html>
