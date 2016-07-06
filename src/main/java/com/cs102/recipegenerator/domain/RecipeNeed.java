/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author egedarcho
 */
@Entity
public class RecipeNeed implements Serializable {

    @Id
    private Long id;
    
    private int amount;
    
    @ManyToOne
    private Ingredient ingredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
