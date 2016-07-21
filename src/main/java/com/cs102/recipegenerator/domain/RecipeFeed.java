/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author egedarcho
 */
@Entity
public class RecipeFeed implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date cookDate;
    
    @ManyToOne
    private Recipe recipe;
    
    public RecipeFeed (User user, Recipe recipe) {
     this.user= user;
     this.cookDate = new Date();
     this.recipe = recipe;
     
}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Date getCookDate() {
        return cookDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCookDate(Date cookDate) {
        this.cookDate = cookDate;
    }
    
    public Recipe getRecipe(){
        return recipe;
    }
    public void setRecipe(Recipe recipe){
        this.recipe = recipe;
    }
}
