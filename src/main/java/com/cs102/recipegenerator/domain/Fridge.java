/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs102.recipegenerator.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author egedarcho
 */
@Entity
public class Fridge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    @OneToOne(mappedBy = "fridge")
    private User user;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<FridgeItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<FridgeItem> getItems() {
        return items;
    }

    public void setItems(List<FridgeItem> items) {
        this.items = items;
    }
    public void addItem(FridgeItem item){
        items.add(item);
    }
    
}
