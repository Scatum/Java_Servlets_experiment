/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imlp;

import dao.ProjectDao;
import domains.Project;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.sql.SQLException;
import java.util.List;


/**
 * @author ScatUm
 */
public class ProjectDaoImpl implements ProjectDao {

    Session session = null;

    public ProjectDaoImpl() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addProject(Project project) throws SQLException {

        try {
            // session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        }
    }

    @Override
    public void updateProject(Project project) throws SQLException {
        // Session session = null;
        try {

            //   session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(project);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        }
    }

    @Override
    public void deleteProject(Project project) throws SQLException {
        // Session session = null;
        try {
            //   session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(project);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                // session.close();
            }
        } //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Project> getProjects() throws SQLException {
        List<Project> projects = null;

        //   Session session = null;
        try {
            //    session = HibernateUtil.getSessionFactory().openSession();
            projects = session.createCriteria(Project.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                //  session.close();
            }
        }

        return projects;
    }

    @Override
    public Project getProject(int id) throws SQLException {
        Project result = null;
        //      Session session = null;
        try {
            //   session = HibernateUtil.getSessionFactory().openSession();
            result = (Project) session.load(Project.class, id);
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
