package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserManager {

    public static void saveUser(User user) {
        Session ss = SessionManager.getSession();
        ss.save(user);
        ss.getTransaction().commit();
        ss.close();
    }

    public static User getUserByUserName(String username) {
        
        Session ss = SessionManager.getSession();
        User user = (User) ss.createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
        ss.close();
        return user;
    }

    public static List<User> getAllUsers() {
        Session ss = SessionManager.getSession();
        List users = ss.createCriteria(User.class).list();
        ss.close();
        return users;
    }
}
