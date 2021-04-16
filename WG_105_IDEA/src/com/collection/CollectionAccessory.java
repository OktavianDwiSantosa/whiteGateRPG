package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionAccessory {
    private HashMap<String, Accessory> accessoryHM = new HashMap<>();

    // Constructor
    public CollectionAccessory() {

    }

    // Getter & Setter
    public HashMap<String, Accessory> getAccessoryHM() {
        return accessoryHM;
    }

    public void setAccessoryHM(HashMap<String, Accessory> vAccessoryHM) {
        this.accessoryHM = vAccessoryHM;
    }

    // Methods
    public void addAccessoryHM(String accessoryName, Accessory objAccessory) {
        accessoryHM.put(accessoryName, objAccessory);
    }

    public Accessory takeAccessoryHM(String accessoryName) {
        return getAccessoryHM().get(accessoryName);
    }

}
