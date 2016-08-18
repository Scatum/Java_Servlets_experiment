/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import domains.Project;

/**
 *
 * @author ScatUm
 */
public interface ProjectDao {
    
      public void addProject(Project project) throws SQLException;
    
    public void updateProject(Project project) throws SQLException;
    
    public void deleteProject(Project project) throws SQLException;
    
    public Project getProject(int id) throws SQLException;
       
    public List<Project> getProjects() throws SQLException; 
}
