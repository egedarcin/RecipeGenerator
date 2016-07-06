/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author egedarcho
 */
public class UserManager {

    public static void saveUser(User user) {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session ss = sf.openSession();

        ss.beginTransaction();

        ss.save(user);
        ss.getTransaction().commit();
        ss.close();

    }

    public static User getUserByUserName(String username) {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session ss = sf.openSession();

        User user = (User) ss.createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();

        ss.close();

        return user;

    }
    
    
    public static List<User> getAllUsers() {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session ss = sf.openSession();

        List users = ss.createCriteria(User.class).list();

        ss.close();

        return users;

    }
}
