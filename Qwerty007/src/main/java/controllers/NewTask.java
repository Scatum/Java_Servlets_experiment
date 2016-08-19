package controllers;


import domains.Project;
import domains.Task;
import domains.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by ScatUm on 15.08.2016.
 */
@WebServlet("/new-task")
public class NewTask extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String projectId = request.getParameter("projects");
        String taskName = request.getParameter("task_name");
        String priority = request.getParameter("priority");
        String assignUserId = request.getParameter("assign_user");
        String taskPont = request.getParameter("point");
        String taskDescription = request.getParameter("task-description");

        Task newTask = new Task();
        Project project = null;
        try {
            project = Factory.getInstance().getProjectDao().getProject(Integer.valueOf(projectId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        newTask.setProject(project);
        newTask.setProject_id(Integer.valueOf(projectId));
        newTask.setName(taskName);
        newTask.setPriority(priority);
        System.out.print("******************* " + assignUserId);
        newTask.setUser_id(Integer.valueOf(assignUserId));


        newTask.setPoint(Integer.valueOf(taskPont));
        newTask.setDescription(taskDescription);
        User user = (User) request.getSession(false).getAttribute("user");
        Calendar currenttime = Calendar.getInstance();
        Date currentDate = new Date((currenttime.getTime()).getTime());
        newTask.setCreator_id(user.getU_id());
        newTask.setType("on_hold");
        newTask.setCreate_date(currentDate);

        try {
            Factory.getInstance().getTaskDao().addTask(newTask);
            request.getRequestDispatcher("WEB-INF/adminView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
