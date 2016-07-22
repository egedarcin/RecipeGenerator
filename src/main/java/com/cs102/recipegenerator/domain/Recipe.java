package com.cs102.recipegenerator.domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

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

    @ElementCollection(fetch = FetchType.EAGER)
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

    public void setCuisine(int c) {
        this.cuisine = c;
    }

    public List<RecipeNeed> getNeeds() {
        return needs;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public void addNeeds(RecipeNeed need) {
        needs.add(need);
    }

    public void addSteps(String step) {
        steps.add(step);
    }

    public ImageIcon getImageIcon() throws MalformedURLException, IOException {
        URL url;
        String urlIcon;
        BufferedImage img;
        ImageIcon icon = null;
        try {
            urlIcon = getImageUrl();
            url = new URL(urlIcon);
            img = ImageIO.read(url);
            icon = new ImageIcon(img);
            Image image = icon.getImage();
            Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newimg);

            //more code goes here
        } catch (MalformedURLException ex) {
//do exception handling here
        }

        return icon;
    }
    

}
