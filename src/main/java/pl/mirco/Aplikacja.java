package pl.mirco;

import com.cs102.recipegenerator.domain.Fridge;
import com.cs102.recipegenerator.domain.User;
import com.cs102.recipegenerator.manager.UserManager;
import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.Ingredient;
import com.cs102.recipegenerator.manager.IngredientManager;
        
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
       List<Ingredient> allFridgeItems = IngredientManager.getAllIngredient();

        User user = new User();
        user.setUsername("Ege");
        user.setPassword("Darcin");
        Fridge fridge = new Fridge();
        user.setFridge(fridge);
        fridge.setUser(user);

        for (int index = 0; index < 5; index++) {
            FridgeItem fridgeItem = new FridgeItem();
            fridgeItem.setAmount(200);
            fridgeItem.setIngredient(allFridgeItems.get(index));
            fridge.addItem(fridgeItem);
        }

        UserManager.saveUser(user);
        System.out.print(UserManager.getAllUsers());

    }
}
