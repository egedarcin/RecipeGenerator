/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
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
}
