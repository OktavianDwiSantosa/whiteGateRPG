package com.main;

public class Weapon extends Item {
    private String weaponType; // Tipe Weapon --> Sword, Projectile, Gauntlet, Saber, Cyberware
    private Integer weaponLevel; // 1, 2 & 3

    // Constructor
    public Weapon(String vName, String vDescription, String vWeaponType, Integer vWeaponLevel,
                  Double vStrengthMultiplier) {
        super(vName, vDescription);
        this.strengthMultiplier = vStrengthMultiplier;
        this.weaponType = vWeaponType;
        this.weaponLevel = vWeaponLevel;
    }

    // Getter & Setter
    public String getWeaponType() {
        return weaponType;
    }

    public void setType(String vWeaponType) {
        this.weaponType = vWeaponType;
    }

    public Integer getWeaponLevel() {
        return weaponLevel;
    }

    public void setWeaponLevel(Integer vWeaponLevel) {
        this.weaponLevel = vWeaponLevel;
    }

    // Methods
    @Override
    public void describe() { // Tampilkan atribut dari Weapon
        super.describe();
        System.out.println("Weapon Type : " + weaponType);
        System.out.println("Weapon Level : " + weaponLevel);
        System.out.printf("Increase %1.0f%% of a hero's Strength \n", (strengthMultiplier * 100));
    }

}
