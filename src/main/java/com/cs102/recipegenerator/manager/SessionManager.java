/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//heleloy kod degisitirisesf
/**
 *
 * @author egedarcho
 */
public class SessionManager {
    public static Session getSession(){
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session ss = sf.openSession();

        return ss;

    }
}
