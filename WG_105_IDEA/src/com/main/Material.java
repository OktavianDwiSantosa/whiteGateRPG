package com.main;

public class Material extends Thing {
    private String materialType; // Tipe material --> (Rare & Common)

    // Constructor
    public Material(String vName, String vDescription, String vMaterialType) {
        super(vName, vDescription);
        this.materialType = vMaterialType;
    }

    // Getter & Setter
    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String vMaterialType) {
        this.materialType = vMaterialType;
    }

    // Methods
    @Override
    public void describe() {
        super.describe();
        System.out.println("Type : " + materialType);
    }

}
