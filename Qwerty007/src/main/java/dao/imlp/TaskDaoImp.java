/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imlp;


import dao.TaskDao;
import domains.Task;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;


/**
 * @author ScatUm
 */
public class TaskDaoImp implements TaskDao {


    Session session = null;

    public TaskDaoImp() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addTask(Task task) throws SQLException {
        try {
            //  session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        }
    }

    @Override
    public void updateTask(Task task) throws SQLException {

        try {
            session.beginTransaction();
            session.update(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        }
    }

    @Override
    public void deleteTask(Task task) throws SQLException {
        try {
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTaskById(int id) throws SQLException {

        try {
            session.beginTransaction();
            Task task = (Task) session.load(Task.class, id);
            session.delete(task);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.

    }


    @Override
    public List<Task> getTasks() throws SQLException {
        List<Task> tasks = null;

        try {
            session.beginTransaction();
            tasks = session.createCriteria(Task.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                //  session.close();
            }
        }

        return tasks;
    }

    @Override
    public Task getTask(int id) throws SQLException {
        Task result = null;
        try {
            result = (Task) session.load(Task.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();

            }
        }
        return result;
    }

}
