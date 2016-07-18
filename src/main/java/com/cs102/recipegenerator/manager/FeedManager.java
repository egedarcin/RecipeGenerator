/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;
import com.cs102.recipegenerator.domain.RecipeFeed;
import org.hibernate.Session;
/**
 *
 * @author egedarcho
 */
//hejeasd
public class FeedManager {
    public static void saveFeed(RecipeFeed feed) {
        Session ss = SessionManager.getSession();
        ss.save(feed);
        ss.getTransaction().commit();
        ss.close();
    }
}
