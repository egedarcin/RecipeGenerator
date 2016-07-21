package test;

import com.cs102.recipegenerator.domain.Fridge;
import com.cs102.recipegenerator.domain.User;
import com.cs102.recipegenerator.manager.UserManager;
import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.Ingredient;
import com.cs102.recipegenerator.domain.Recipe;
import com.cs102.recipegenerator.domain.RecipeNeed;
import com.cs102.recipegenerator.manager.IngredientManager;
import com.cs102.recipegenerator.manager.RecipeManager;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JFrame;

public class testStuff {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
       setSomethingstoRecipes();
    }

    public static void setSomethingstoRecipes() {
        Recipe recipe = new Recipe();
        recipe.setName("TheSuperPotato");
        recipe.setCuisine(Recipe.AMERICAN);
        recipe.addSteps("1. Preheat the oven to 220 degrees Celcius.");
        recipe.addSteps("2. Pierce the potatoes several times with a fork. Place in the oven and bake for 1 hour, or until tender when pierced with a fork. Remove and leave the oven on. ");
        Ingredient potato = IngredientManager.findByName("potato");
        RecipeNeed recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(4);
        recipeNeed.setIngredient(potato);
        recipe.getNeeds().add(recipeNeed);

        Ingredient tomato = IngredientManager.findByName("tomato");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(2);
        recipeNeed.setIngredient(tomato);
        recipe.getNeeds().add(recipeNeed);
        RecipeManager.saveRecipe(recipe);
    }

    public static void setSomethingstoFridge() {
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
