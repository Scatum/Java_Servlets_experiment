/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import domains.Task;
import domains.User;
import utils.UtilPM;

/**
 *
 * @author ScatUm
 */
@WebServlet("/user-data-table")
public class UserDataTable extends HttpServlet{
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException{
        List<Task> tasks = null;
         try {
             tasks = Factory.getInstance().getTaskDao().getTasks();
             
        //String json = new Gson().toJson(tasks);
        //response.getWriter().write(json);
        JSONArray list = new JSONArray();
             
//        JSONObject j = new JSONObject();
//        j.put("key",list);
        JsonObject obj = new JsonObject();
        JsonArray array = new JsonArray();
        Factory f = Factory.getInstance();
        for(int x = 0; x<tasks.size(); x++){
            JsonArray data = new JsonArray();
            Task task = tasks.get(x);
            
            data.add(new JsonPrimitive("<a href='editTask.jsp?id=" + task.getId() + "'>" + task.getName() + "</a>"));
            data.add(new JsonPrimitive(f.getUserDao().getUser(task.getCreator_id()).getU_name()));
            data.add(new JsonPrimitive(task.getProject().getName()));
            data.add(new JsonPrimitive(UtilPM.getTaskProgressByValue(task.getType())));
            data.add(new JsonPrimitive(task.getPoint()));
            data.add(new JsonPrimitive(task.getPriority()));
            data.add(new JsonPrimitive(task.getDescription()));
            data.add(new JsonPrimitive(String.valueOf(task.getCreate_date())));
            if(task.getUser_id() > 0){
                User assignedUser = f.getUserDao().getUser(task.getUser_id());
                data.add(new JsonPrimitive(assignedUser.getU_name()));
            }else {
                 data.add(new JsonPrimitive("Un-Signed"));
            }
           
            
            array.add(data);
        }
       
        obj.add("data", array);
        
   
        String res = new Gson().toJson(obj);
        response.getWriter().write(res);
        
        
         
         } catch (SQLException ex) {
             Logger.getLogger(UserDataTable.class.getName()).log(Level.SEVERE, null, ex);
         } 
          
             
         }
    
}
