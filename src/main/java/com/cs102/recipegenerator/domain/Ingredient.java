package com.cs102.recipegenerator.domain;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.swing.ImageIcon;

@Entity
public class Ingredient implements Serializable {

    private final String IMAGE_URL = "https://s3.eu-central-1.amazonaws.com/cs102recipegenerator/ingredients/";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public String getImageUrl() {
        return IMAGE_URL + name + ".png";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
