/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.Ingredient;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author egedarcho
 */
public class IngredientManager {
    
      public static List<FridgeItem> getAllFridgeItems() {
    
        Session ss = SessionManager.getSession();
        List fridgeItems = ss.createCriteria(FridgeItem.class).list();
        ss.close();
        return fridgeItems;

    }
      public static void putIngredients(Ingredient ingredient){
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
}
