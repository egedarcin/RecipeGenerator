package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.Ingredient;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class IngredientManager {


    public static void putIngredients(Ingredient ingredient) {
        Session ss = SessionManager.getSession();
        ss.save(ingredient);
        ss.getTransaction().commit();
        ss.close();
    }

    public static List<Ingredient> getAllIngredient() {
        Session ss = SessionManager.getSession();
        List ingredients = ss.createCriteria(Ingredient.class).list();
        ss.close();
        return ingredients;
    }
    public static Ingredient findByName(String name) {
    Session ss = SessionManager.getSession();
      Ingredient ingredient = (Ingredient) ss.createCriteria(Ingredient.class)
         .add(Restrictions.eq("name", name)).uniqueResult();
       ss.close();
     return ingredient;
   }

}
