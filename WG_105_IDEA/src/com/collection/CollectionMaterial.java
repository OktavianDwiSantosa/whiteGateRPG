package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionMaterial {
    private HashMap<String, Material> materialHM = new HashMap<>();

    // Constructor
    public CollectionMaterial() {
        Material objMaterial01 = new Material("Steel", "", "Common");
        addMaterialHM("Steel01", objMaterial01);

        Material objMaterial02 = new Material("Copper", "", "Common");
        addMaterialHM("Steel02", objMaterial02);
    }

    // Getter & Setter
    public HashMap<String, Material> getMaterialHM() {
        return materialHM;
    }

    public void setMaterialHM(HashMap<String, Material> vMaterialHM) {
        this.materialHM = vMaterialHM;
    }

    // Methods
    public void addMaterialHM(String materialName, Material objMaterial) {
        materialHM.put(materialName, objMaterial);
    }

    public Material takeMaterialHM(String materialName) {
        return getMaterialHM().get(materialName);
    }

}
