package com.main;

import java.util.ArrayList;

public class Enemy extends GameCharacter {
    private Integer enemyGold;
    private ArrayList<Material> materials = new ArrayList<>();

    // Constructor
    public Enemy(String vName, Integer vLevel, Integer vExp, Integer vMaxHealth, Integer vMaxShields, Integer vStrength,
                 Integer vEnemyGold) {
        super(vName, "", vLevel, vExp, vMaxHealth, vMaxShields, vStrength);
        this.enemyGold = vEnemyGold;
    }

    // Getter & Setter
    public Integer getEnemyGold() {
        return enemyGold;
    }

    public void setEnemyGold(Integer vEnemyGold) {
        this.enemyGold = vEnemyGold;
    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> vMaterials) {
        this.materials = vMaterials;
    }

    // Method
    @Override
    public void describe() { // Menampilkan status enemy ketika battle
        System.out.println("\n======================================");
        System.out.println("            Enemy status");
        System.out.println("======================================");
        super.describe();
        System.out.println("======================================\n");
    }

    public void describe(String detail) { // Menampilkan status enemy dengan lengkap
        super.describe();
        System.out.println("\nGold : " + enemyGold);
        System.out.println("\nAvailable Material");

        for (int i = 0; i < materials.size(); i++) {
            System.out.println("\nMaterial " + (i + 1));
            System.out.println("Material Name : " + getMaterials().get(i).getName());
            System.out.println("Material Type : " + getMaterials().get(i).getMaterialType());
        }
    }

    public void addMaterial(Material objMaterial) {
        materials.add(objMaterial);
    }

}
