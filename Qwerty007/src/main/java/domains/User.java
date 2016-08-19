/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import javax.persistence.*;
import java.util.Set;

/**
 * @author ScatUm
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_email")
    private String email;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_about")
    private String about;

    @Column(name = "u_is_admin")
    private boolean isAdmin;

    private Set<Task> tasks;

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public int getU_id() {
        return id;
    }

    public void setU_id(int id) {
        this.id = id;
    }

    public String getU_name() {
        return name;
    }

    public void setU_name(String name) {
        this.name = name;
    }

    public String getU_email() {
        return email;
    }

    public void setU_email(String email) {
        this.email = email;
    }

    public String getU_password() {
        return password;
    }

    public void setU_password(String password) {
        this.password = password;
    }

    public String getU_about() {
        return about;
    }

    public void setU_about(String about) {
        this.about = about;
    }

    public boolean isU_is_admin() {
        return isAdmin;
    }

    public void setU_is_admin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


}
