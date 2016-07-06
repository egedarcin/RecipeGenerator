/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author egedarcho
 */
@Entity
public class Recipe implements Serializable {

    private final String IMAGE_URL = "http://s3url/";

    private final int ITALIAN = 0;
    private final int TURKISH = 1;
    private final int FRENCH = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private int cuisine;

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

}
