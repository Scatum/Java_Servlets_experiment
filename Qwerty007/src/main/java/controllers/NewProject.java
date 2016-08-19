package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.domains.Project;
import java.domains.User;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by ScatUm on 15.08.2016.
 */

@WebServlet("/new-project")
public class NewProject extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User)request.getSession(false).getAttribute("user");
        String name = request.getParameter("proj_name");
        String description = request.getParameter("description");
        Calendar currenttime = Calendar.getInstance();
        Date currentDate = new Date((currenttime.getTime()).getTime());
        Project newProject = new Project();
        newProject.setCreator_id(user.getU_id());
        newProject.setDate(currentDate);
        newProject.setDescription(description);
        newProject.setName(name);
        try {
            Factory.getInstance().getProjectDao().addProject(newProject);
            request.getRequestDispatcher("WEB-INF/adminView.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
