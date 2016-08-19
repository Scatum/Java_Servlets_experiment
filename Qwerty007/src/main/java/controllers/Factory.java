package controllers;





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.dao.ProjectDao;
import java.dao.TaskDao;
import java.dao.UserDao;
import java.dao.imlp.ProjectDaoImpl;
import java.dao.imlp.TaskDaoImp;
import java.dao.imlp.UserDaoImpl;

/**
 *
 * @author ScatUm
 */
public class Factory {
    private static Factory instance ;
    private UserDao userDao;
    private TaskDao taskDao;
    private ProjectDao projectDao;
    private Factory(){     
    }
    public static Factory getInstance(){
        if(instance==null)
        instance = new Factory();
        return Factory.instance;
    }
    
    public UserDao getUserDao(){
        if(userDao == null) userDao = new UserDaoImpl();
        return userDao;
    }
    
    public TaskDao getTaskDao(){
        if(taskDao == null) taskDao = new TaskDaoImp();
        return taskDao;
    }
    
    public ProjectDao getProjectDao(){
        if(projectDao == null) projectDao = new ProjectDaoImpl();
        return projectDao;
    }
}
