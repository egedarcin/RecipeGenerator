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
        recipe.setName("ZucchiniFritters");
        recipe.setCuisine(Recipe.TURKISH);
        recipe.addSteps("1.Place the  grated zucchini in a strainer over a large bowl. Toss it with salt and set aside for 1 hour. Squeeze in a clean kitchen towel to extract excess moisture.");
        recipe.addSteps("2.Transfer to a bowl. First stir in herbs, onions and feta cheese . Add eggs and flour to the vegetables and mixed until evenly combined.");
        recipe.addSteps("3. Heat vegetable oil in a large heavy-bottomed frying pan over medium- high heat. Meanwhile, line a large plate with paper towel  to drain excess oil.");
        recipe.addSteps("4. Carefully drop a heaped tablespoon of zucchini mixture in to pan; repeat, spacing fritters a few inches apart. Pat them down  so they become like a flat.");
        recipe.addSteps("5. Fry until golden brown on both sides. With a slotted spoon tranfer patties to the plate.");
        recipe.addSteps("6.Serve  cold or at room temperature with sour cream.");
        
        Ingredient zucchini = IngredientManager.findByName("zucchini");
        RecipeNeed recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(3);
        recipeNeed.setIngredient(zucchini);
        recipe.getNeeds().add(recipeNeed);

        Ingredient eggs = IngredientManager.findByName("eggs");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(3);
        recipeNeed.setIngredient(eggs);
        recipe.getNeeds().add(recipeNeed);
        RecipeManager.saveRecipe(recipe);
        
        Ingredient onions = IngredientManager.findByName("onions");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(3);
        recipeNeed.setIngredient(onions);
        recipe.getNeeds().add(recipeNeed);
        RecipeManager.saveRecipe(recipe);
        
        Ingredient cheddar = IngredientManager.findByName("cheddar");
        recipeNeed = new RecipeNeed();
        recipeNeed.setAmount(10);
        recipeNeed.setIngredient(cheddar);
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
            fridgeItem.setAmount(20);
            fridgeItem.setIngredient(allFridgeItems.get(index));
            fridge.addItem(fridgeItem);
        }

        UserManager.saveUser(user);
        System.out.print(UserManager.getAllUsers());
    }
}
