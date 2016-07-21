package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recipe implements Serializable {

    private final String IMAGE_URL = "https://s3.eu-central-1.amazonaws.com/cs102recipegenerator/recipes/";

    private final int ITALIAN = 0;

    private final int TURKISH = 1;

    private final int FRENCH = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int cuisine;

    @ElementCollection
    private List<String> steps;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RecipeNeed> needs;

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

    public List<RecipeNeed> getNeeds() {
        return needs;
    }

    public List<String> getSteps() {
        return steps;
    }
}
