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
        recipe.addSteps("3. Meanwhile, in a small saucepan, combine the flour, and a pinch of salt. Gradually whisk in 1 cup of the milk until the flour dissolves. Cook, stirring, over medium heat for 5 minutes, or until thickened. Remove from the heat. Stir in the cheese until smooth. Set aside.");
        recipe.addSteps("4. Holding the potatoes with an oven mitt, cut in half lengthwise. Scoop the flesh out into a bowl, leaving a ¼\" shell. Place the shells on a baking sheet. Mash the flesh with a potato masher.");
        recipe.addSteps("5. Stir in the remaining 2/3 cup milk and 1/4 teaspoon salt until smooth. Spoon the potato mixture into the shells. Top with the broccoli, bacon, and cheese sauce. Bake for 10 minutes, or until heated through.");
        
        Ingredient potato = IngredientManager.findByName("potato");
        RecipeNeed recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(4);
        recipeNeed.setIngredient(potato);
        recipe.getNeeds().add(recipeNeed);

        Ingredient milk = IngredientManager.findByName("milk");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(3);
        recipeNeed.setIngredient(milk);
        recipe.getNeeds().add(recipeNeed);
        RecipeManager.saveRecipe(recipe);
        
        Ingredient bacon = IngredientManager.findByName("bacon");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(3);
        recipeNeed.setIngredient(bacon);
        recipe.getNeeds().add(recipeNeed);
        RecipeManager.saveRecipe(recipe);
        
        Ingredient broccoli = IngredientManager.findByName("broccoli");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(10);
        recipeNeed.setIngredient(broccoli);
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
