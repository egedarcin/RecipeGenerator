/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author egedarcho, umutakos, senaxi, cntysz
 * 
 */
@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String username;
    
    private String password;
    
    @OneToOne
    private List<Recipe> LastRecipes;
    
    @OneToOne
    private List<Recipe> FavouriteRecipes;
   
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Fridge fridge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }
   public List<Recipe> getLastRecipes() {
        return LastRecipes;
    }

    public void setLastRecipes(List<Recipe> LastRecipes) {
        this.LastRecipes = LastRecipes;
    }
    public void addLastRecipe(Recipe LastRecipe){
        LastRecipes.add(LastRecipe);
    }
    
    
}
