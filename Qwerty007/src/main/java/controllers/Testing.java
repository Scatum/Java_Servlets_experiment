/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author ScatUm
 */
@WebServlet("/testing")
public class Testing extends HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
         Factory f = Factory.getInstance();
           
         /*try {
          *//*   List <Task> l = new ArrayList<Task>();
             l.addAll(f.getProjectDao().getProject(1).getTasks());
             response.getWriter().write(l.get(0).getName());*//*
         } catch (SQLException ex) {
             Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
         }
     }*/
     }
}
