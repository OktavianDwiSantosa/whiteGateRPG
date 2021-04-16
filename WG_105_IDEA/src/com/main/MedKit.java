package com.main;

public class MedKit extends Item {

    // Constructor
    public MedKit(String vName, String vDescription, Double vHealthMultiplier) {
        super(vName, vDescription);
        this.healthMultiplier = vHealthMultiplier;
    }

    // Methods
    @Override
    public void describe() { // Tampilkan atribut dari class RecoveryItem
        super.describe();
        System.out.printf("Restores %1.0f%% of a hero's maximum Health \n\n", (super.healthMultiplier * 100));
    }

}
