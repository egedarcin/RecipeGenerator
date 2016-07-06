package pl.mirco;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import pl.mirco.model.Person;

public class Aplikacja {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure();

		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf = configuration.buildSessionFactory(sr);

		Session ss = sf.openSession();
		
                	ss.beginTransaction();
                        
            List<Person> list = ss.createCriteria(Person.class).list();
//		Person user1 = new Person();
//		user1.setFirstName("Adam");
//		user1.setLastName("Kowaliski");

	
		// saving objects to session
//		ss.save(user1);
		// ss.save(user2);
		ss.getTransaction().commit();
		ss.close();

		
}}
