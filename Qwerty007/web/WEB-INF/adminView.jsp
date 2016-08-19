<%-- 
    Document   : aut
    Created on : 08.08.2016, 21:21:34
    Author     : ScatUm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="utils.TaskProgress" %>
<%@ page import="domains.User" %>
<%@ page import="dao.ProjectDao" %>
<%@ page import="controllers.Factory" %>
<%@ page import="domains.Project" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Admin Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="../js/aut.js"></script>
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="../js/dataTable.js"></script>
    <script src="../js/adminView.js"></script>
    <link rel="stylesheet" href="../css/userView.css">
</head>
<body>

<%

    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Expires", "0");
    response.setDateHeader("Expires", -1);
%>

<fieldset id="admin-select">
    <label for="admin-option"><h1><%=((User) request.getSession(false).getAttribute("user")).getU_name() %>! Welcome to
        ProjMan</h1> Do Something</label>
    <select id="admin-option" name="admin-option">
        <option value="new-project">New Project</option>
        <option value="new-task">New Task</option>
        <option value="all-tasks" selected>All Tasks</option>
        <option value="all-developers">All Developers</option>

    </select>
    <a class="logout-admin" href="logout.jsp">Log Out</a>
</fieldset>

<div id="all-tasks-content" class="admin-function">

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

<form action="new-project" method="post" class="admin-function" id="new-project-content">

    <label for="description">Description</label>
    <textarea id="description" name="description"> </textarea>

    <label for="proj-name">Name:</label>
    <input type="text" id="proj-name" name="proj_name">
    <button type="submit" class="done-btn">Done</button>

</form>


<%--New Task Area--%>
<form action="new-task***" method="post" class="admin-function" id="new-task-content">
    <%
        ProjectDao projectDao = Factory.getInstance().getProjectDao();
        List<Project> projectList = projectDao.getProjects();
    %>
    <div class="task-top-content">
        <div class="to-left">
            <label for="projects">Select Project</label>
            <select id="projects" name="projects">
                <option value="" disabled selected></option>
                <%
                    for (Project project : projectList) {
                        String selectOption = "<option value=" + project.getId();

                        selectOption += ">" + project.getName() + "</option>";
                %>
                <%= selectOption%>
                <%}%>
            </select>
        </div>
        <div class="to-left">
            <label for="proj-name">Name:</label>
            <input type="text" id="task-name" name="task_name">
        </div>
        <div class="to-left">
            <label for="priority">Select Priority</label>
            <select id="priority" name="priority">
                <option value="high" selected> High</option>
                <option value="low"> Low</option>
                <option value="hot_fix"> Hot Fix</option>
            </select>
        </div>
        <div class="to-left">
            <label for="job">Assign Task to </label>
            <select id="job" name="assign_user">
                <option value="0" selected>Un Signed Task</option>
                <%
                    List<User> users = Factory.getInstance().getUserDao().getFiltrUsers();
                    for (int x = 0; x < users.size(); x++) {
                        String selectUser = "<option value=" + users.get(x).getU_id();
                        selectUser += ">" + users.get(x).getU_name() + "</option>";
                %>
                <%= selectUser%>
                <%}%>
            </select>

        </div>
        <div>
            <label for="point">Point</label>
            <input type="number" id="point" name="point" value="20">
        </div>
    </div>

    <div class="to-left">
        <label for="description">Description</label>
        <textarea id="task-description" name="task-description"> </textarea>


    </div>

    <button class="save" type="submit">OK</button>


</form>

<form action="registration" method="post" class="admin-function" id="all-developers-content">
    <table id="developers-info-data-table" class="display" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>Name</th>
            <th>Profession</th>
            <th>To Do</th>
            <th>On Hold</th>
            <th>In Progres</th>
            <th>In Review</th>
            <th>Done</th>
            <th>Total</th>

        </tr>
        </thead>


    </table>

</form>

</body>
</html>
</html>
