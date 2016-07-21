package com.cs102.recipegenerator.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionManager {

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);
        Session ss = sf.openSession();
        ss.beginTransaction();
        return ss;
    }
}
