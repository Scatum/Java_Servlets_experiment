
package dao;

import java.sql.SQLException;
import java.util.List;
import domains.User;

/**
 *
 * @author ScatUm
 */
public interface UserDao {
     public void addUser(User user) throws SQLException;
    
    public void deleteUser(User user) throws SQLException;
    
    public User getUser(int id) throws SQLException;
    
    public User LoginUser(String email, String password) throws SQLException;
    
    public List<User> getUsers() throws SQLException;
    
    public List<User> getFiltrUsers() throws SQLException;
}
