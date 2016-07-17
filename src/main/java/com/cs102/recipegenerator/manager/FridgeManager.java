/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;

import com.cs102.recipegenerator.domain.FridgeItem;
import com.cs102.recipegenerator.domain.User;
import java.util.List;
/*
 *
 * @author egedarcho
 */
//buikisi geldiasd
public class FridgeManager {
    

  public List<FridgeItem> getItemsForUser(String username ){
    User user = UserManager.getUserByUserName(username);
    return user.getFridge().getItems();
  } 
  
       
}
