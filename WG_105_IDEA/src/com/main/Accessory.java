package com.main;

public class Accessory extends Item {

    // Constructor
    public Accessory(String vName, String vDescription, Double vStrengthMultiplier, Double vHealthMultiplier,
                     Integer vStrengthValue, Integer vHealthValue) {
        super(vName, vDescription);
        this.strengthMultiplier = vStrengthMultiplier;
        this.healthMultiplier = vHealthMultiplier;
        this.strengthValue = vStrengthValue;
        this.healthValue = vHealthValue;
        this.shieldsMultiplier = 0.0;
        this.shieldsValue = 0;
    }

    // Methods
    @Override
    public void describe() { // Tampilkan atribut dari class Weapon
        super.describe();
        System.out.printf("Increase %1.0f%% of a hero's Strength \n", (this.strengthMultiplier * 100));
        System.out.printf("Increase %1.0f%% of a hero's Max Health \n", (this.healthMultiplier * 100));
    }

}
