package dao;

import domains.User;

import java.sql.SQLException;
import java.util.List;


/**
 * @author ScatUm
 */
public interface UserDao {
    public void addUser(User user) throws SQLException;

    public void deleteUser(User user) throws SQLException;

    public User getUser(int id) throws SQLException;

    public User loginUser(String email, String password) throws SQLException;

    public List<User> getUsers() throws SQLException;

    public List<User> getFiltrUsers() throws SQLException;
}
