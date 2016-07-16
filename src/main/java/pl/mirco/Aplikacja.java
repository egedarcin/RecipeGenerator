package pl.mirco;

import com.cs102.recipegenerator.domain.Fridge;
import com.cs102.recipegenerator.domain.User;
import com.cs102.recipegenerator.manager.UserManager;
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

        Fridge fridge = new Fridge();

        User user1 = new User();
        user1.setUsername("Ege");
        user1.setPassword("Darcin");
        user1.setFridge(fridge);

//		 saving objects to session
        UserManager.saveUser(user1);

        System.out.print(UserManager.getAllUsers());
    }
}
