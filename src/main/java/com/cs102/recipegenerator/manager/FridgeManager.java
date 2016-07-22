package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.User;
import java.util.List;
import org.hibernate.Session;

public class FridgeManager {

    public List<FridgeItem> getItemsForUser(String username) {
        User user = UserManager.getUserByUserName(username);
        return user.getFridge().getItems();
    }
    
    public static List<FridgeItem> getAllFridgeItems() {
        Session ss = SessionManager.getSession();
        List fridgeItems = ss.createCriteria(FridgeItem.class).list();
        ss.close();
        return fridgeItems;
    }
}
