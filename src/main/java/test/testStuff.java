package test;

import com.cs102.recipegenerator.domain.Fridge;
import com.cs102.recipegenerator.domain.User;
import com.cs102.recipegenerator.manager.UserManager;
import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.Ingredient;
import com.cs102.recipegenerator.manager.IngredientManager;
        

import java.util.List;

import javax.swing.JFrame;


public class testStuff {

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
