/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Task;
import domains.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author ScatUm
 */
@WebServlet("/editTask")
public class EditTask extends HttpServlet {
    Task task;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int id = Integer.valueOf(request.getParameter("task-id"));
            task = Factory.getInstance().getTaskDao().getTask(id);
            task.setName(request.getParameter("task-name"));
            task.setType(request.getParameter("task-progres"));

            task.setUser_id(Integer.valueOf(request.getParameter("assign-user")));
            task.setPoint(Integer.valueOf(request.getParameter("task-point")));
            task.setDescription(request.getParameter("task-description"));
            Factory.getInstance().getTaskDao().updateTask(task);
            User user = (User) request.getSession().getAttribute("user");
            if (user.isU_is_admin()) {
                //response.sendRedirect("WEB-INF/adminView.jsp");
                request.getRequestDispatcher("WEB-INF/adminView.jsp").forward(request, response);

            } else {
                //response.sendRedirect("WEB-INF/userHomeView.jsp");
                request.getRequestDispatcher("WEB-INF/userHomeView.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        try {
            Factory.getInstance().getTaskDao().deleteTaskById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
