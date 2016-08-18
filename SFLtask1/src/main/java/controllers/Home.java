
package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domains.User;

@WebServlet("/home")
public class Home extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = ((User)request.getSession(false).getAttribute("user"));
        System.out.print("dddddddddddddddddddddd");
        redirectPageByUserType(user,request,response);
    }

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         User user = null;
         String email = request.getParameter("user_email");
         String password = request.getParameter("user_password");
          try {
           user  =  Factory.getInstance().getUserDao().LoginUser(email, password);
        
        } catch (SQLException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
         redirectPageByUserType(user,request,response);
            
         }

         private void redirectPageByUserType(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             if(user!=null){
                 request.getSession().setAttribute("user", user);
                 if(user.isU_is_admin()){
                     request.getRequestDispatcher("WEB-INF/adminView.jsp").forward(request, response);
                 }
                 else {
                     request.getRequestDispatcher("WEB-INF/userHomeView.jsp").forward(request, response);
                 }
             }
         }
    
}
