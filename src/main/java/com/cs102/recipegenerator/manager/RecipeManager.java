/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.manager;
import com.cs102.recipegenerator.domain.Recipe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 *
 * @author egedarcho
 */
public class RecipeManager {
        public static Recipe getRecipeByRecipeName(String recipeName) {
        Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry();
        SessionFactory sf = configuration.buildSessionFactory(sr);

        Session ss = sf.openSession();

        Recipe recipe = (Recipe) ss.createCriteria(Recipe.class)
                .add(Restrictions.eq("recipename", recipeName)).uniqueResult();

        ss.close();

        return recipe;
 }
}
