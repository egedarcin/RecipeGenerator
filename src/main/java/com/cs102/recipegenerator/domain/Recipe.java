package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Recipe implements Serializable {
    @Transient
    private final String IMAGE_URL = "https://s3.eu-central-1.amazonaws.com/cs102recipegenerator/recipes/";
    @Transient
    public static final int ITALIAN = 0;
    @Transient
    public static final int TURKISH = 1;
    @Transient
    public static final int FRENCH = 2;
    @Transient
    public static final int AMERICAN = 3;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int cuisine;

    @ElementCollection
    private List<String> steps = new ArrayList<String>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<RecipeNeed> needs = new ArrayList<RecipeNeed>(); 


    public String getImageUrl() {
        return IMAGE_URL + name + ".png";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNeeds(List<RecipeNeed> needs) {
        this.needs = needs;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public String getName() {
        return name;
    }

    public int getCuisine() {
        return cuisine;
    }
    public void setCuisine(int c){
        this.cuisine = c;
    }

    public List<RecipeNeed> getNeeds() {
        return needs;
    }

    public List<String> getSteps() {
        return steps;
    }
    public void setSteps(List<String> steps){
        this.steps = steps;
    }
   
    public void addNeeds(RecipeNeed need){
        needs.add(need);
    }
    
    public void addSteps(String step){
        steps.add(step);
    }
            
    
}
