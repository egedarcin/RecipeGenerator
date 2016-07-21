package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.User;
import java.util.List;

public class FridgeManager {

    public List<FridgeItem> getItemsForUser(String username) {
        User user = UserManager.getUserByUserName(username);
        return user.getFridge().getItems();
    }
}
