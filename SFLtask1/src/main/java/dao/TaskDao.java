/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import domains.Task;

/**
 *
 * @author ScatUm
 */
public interface TaskDao {
    
    public void addTask(Task task) throws SQLException;
    
    public void updateTask(Task task) throws SQLException;
    
    public void deleteTask(Task task) throws SQLException;

    public void deleteTaskById(int id) throws SQLException;

    public Task getTask(int id) throws SQLException;
       
    public List<Task> getTasks() throws SQLException;    
}
