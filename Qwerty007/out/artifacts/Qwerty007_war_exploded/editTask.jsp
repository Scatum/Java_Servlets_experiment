<%-- 
    Document   : edit-task
    Created on : 11.08.2016, 14:44:49
    Author     : ScatUm
--%>

<%@page import="controllers.Factory" %>
<%@page import="domains.Task" %>
<%@page import="domains.User" %>
<%@page import="utils.UtilPM" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Edit Task</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="js/proj-ajax.js"></script>

    <link rel="stylesheet" href="css/edit_task.css">
</head>
<body>

<div class="standart-content">
    <%
        Task editableTask = (Factory.getInstance().getTaskDao().getTask(Integer.valueOf(request.getParameter("id"))));
        User user = (User) request.getSession(false).getAttribute("user");
        List<User> users = Factory.getInstance().getUserDao().getFiltrUsers();
    %>
    <h1>Edit Task: <%= editableTask.getName() %>
    </h1>

    <fieldset>
        <legend><span class="number"></span>Task info</legend>
        <div class="chang-fild">
            <label for="name">Name:</label>
            <input type="text" id="name" name="task-name" value="<%= editableTask.getName() %>">
            <input type="text" id="task-id" name="task-id" value="<%= editableTask.getId()%>" style="display: none;">

        </div>

        <div class="chang-fild">
            <label for="task-progres">Update Work Progres</label>
            <select id="task-progres" name="task-progres">

                <%
                    String[] value = {"on_hold", "to_do", "in_progres", "in_review", "done"};
                    for (int x = 0; x < value.length; x++) {
                        String selectOption = "<option value=" + value[x];
                        if (editableTask.getType().equals(value[x])) {
                            selectOption += " selected";
                        }
                        selectOption += ">" + UtilPM.getTaskProgressByValue(value[x]) + "</option>";
                %>
                <%= selectOption%>
                <%}%>


            </select>

        </div>


        <div class="chang-fild">
            <label for="job">Assign Task to </label>
            <select id="assign-user" name="assign-user">
                <%

                    for (int x = 0; x < users.size(); x++) {
                        String selectUser = "<option value=" + users.get(x).getU_id();
                        if (editableTask.getUser_id() == users.get(x).getU_id()) {
                            selectUser += " selected";
                        }
                        selectUser += ">" + users.get(x).getU_name() + "</option>";
                %>
                <%= selectUser%>
                <%}%>
            </select>


        </div>

        <div class="number-fild">
            <label for="name">Point</label>
            <input type="number" id="point" name="task-point" value="<%= editableTask.getPoint()%>">
        </div>

    </fieldset>

    <fieldset>
        <div class="chang-fild-description">
            <label for="description">Description</label>
            <textarea id="description" name="task-description"><%= editableTask.getDescription()%> </textarea>

        </div>
        <button class="save" type="button" id="save-task-edit">OK</button>
        <% if (user.isU_is_admin()) {%>

        <button class="save delete" id="delete-task" type="button">Delete Task</button>

        <%}%>


    </fieldset>


</div>

</body>
</html>
</html>
