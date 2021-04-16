package com.main;

public class Item extends Thing {
    // Item adalah superclass untuk semua subclass yang dapat di equip
    protected String objGameCharacterName;
    protected boolean isEquip;

    // Atribut-atribut nilai pengali
    protected Double strengthMultiplier;
    protected Double healthMultiplier;
    protected Double shieldsMultiplier;

    // Atribut-atribut untuk menampung hasil perhitungan atribut multiplier
    // milik class Item dengan atribut-atribut milik Hero
    protected Integer strengthValue;
    protected Integer healthValue;
    protected Integer shieldsValue;

    // Constructor
    public Item(String vName, String vDescription) {
        super(vName, vDescription);
        this.objGameCharacterName = "";
        this.strengthMultiplier = 0.0;
        this.healthMultiplier = 0.0;
        this.shieldsMultiplier = 0.0;
        this.strengthValue = 0;
        this.healthValue = 0;
        this.shieldsValue = 0;
        this.isEquip = false;
    }

    // Getter & Setter
    public String getGameCharacter() {
        return objGameCharacterName;
    }

    public void setGameCharacter(String vObjGameCharacterName) {
        this.objGameCharacterName = vObjGameCharacterName;
    }

    public boolean isEquip() {
        return isEquip;
    }

    public void setEquip(boolean vIsEquip) {
        this.isEquip = vIsEquip;
    }

    public Double getStrengthMultiplier() {
        return strengthMultiplier;
    }

    public void setStrengthMultiplier(Double vStrengthMultiplier) {
        this.strengthMultiplier = vStrengthMultiplier;
    }

    public Double getHealthMultiplier() {
        return healthMultiplier;
    }

    public void setHealthMultiplier(Double vHealthMultiplier) {
        this.healthMultiplier = vHealthMultiplier;
    }

    public Double getShieldsMultiplier() {
        return shieldsMultiplier;
    }

    public void setShieldsMultiplier(Double vShieldsMultiplier) {
        this.shieldsMultiplier = vShieldsMultiplier;
    }

    public Integer getStrengthValue() {
        return strengthValue;
    }

    public void setStrengthValue(Integer vStrengthValue) {
        this.strengthValue = vStrengthValue;
    }

    public Integer getHealthValue() {
        return healthValue;
    }

    public void setHealthValue(Integer vHealthValue) {
        this.healthValue = vHealthValue;
    }

    public Integer getShieldsValue() {
        return shieldsValue;
    }

    public void setShieldsValue(Integer vShieldsValue) {
        this.shieldsValue = vShieldsValue;
    }

    // Methods
    @Override
    public void describe() {
        if (isEquip()) { // Jika item di equip oleh GameCharacter
            System.out.println(getName() + " is equipped by " + getGameCharacter());
        }
        super.describe();
    }

    public void equipped(GameCharacter objGameCharacter) { // objGameCharacter yang diparsing akan berubah valuenya
        if (this.getGameCharacter().equals(objGameCharacter.getName())) {
            System.out.println("\nPlease select another weapon!");
            System.out.println(getName() + " has already been equipped by " + objGameCharacter.getName());
        } else {
            System.out.println("\n" + getName() + " successfully equipped by " + objGameCharacter.getName());
            this.setGameCharacter(objGameCharacter.getName());
            this.setEquip(true);

            // Menghitung nilai tambahan ketika memakai item ini
            double buffStrength = objGameCharacter.getStrength() * this.getStrengthMultiplier();
            double buffHealth = objGameCharacter.getMaxHealth() * this.getHealthMultiplier();
            double buffShields = objGameCharacter.getMaxShields() * this.getShieldsMultiplier();

            // Nilai tambahan dari item untuk hero, disimpan di dalam item ini
            // untuk mengingat data jika nanti item dilepas/unequipped
            this.setStrengthValue((int) buffStrength);
            this.setHealthValue((int) buffHealth);
            this.setShieldsValue((int) buffShields);

            // Menambahkan nilai atribut hero dengan nilai tambahan dari item ini
            objGameCharacter.setStrength(this.getStrengthValue() + objGameCharacter.getStrength());
            objGameCharacter.setMaxHealth(this.getHealthValue() + objGameCharacter.getMaxHealth());
            objGameCharacter.setMaxShields(this.getShieldsValue() + objGameCharacter.getMaxShields());
        }
    }

    public void unequipped(GameCharacter objGameCharacter) { // objGameCharacter yang diparsing akan berubah valuenya
        if (!this.getGameCharacter().equals(objGameCharacter.getName())) {
            System.out.println("\nPlease select another weapon!");
            System.out.println(getName() + " hasn't been equipped by " + objGameCharacter.getName());
        } else {
            System.out.println("\n" + getName() + " successfully unequipped by " + objGameCharacter.getName());
            this.setGameCharacter("");
            this.setEquip(false);

            // Menghitung nilai pengurangan ketika hero melepaskan item ini
            int nerfStrength = objGameCharacter.getStrength() - this.getStrengthValue();
            int nerfHealth = objGameCharacter.getMaxHealth() - this.getHealthValue();
            int nerfShields = objGameCharacter.getMaxShields() - this.getShieldsValue();

            // Ubah nilai atribut milik hero dengan nilai pengurangan
            objGameCharacter.setStrength(nerfStrength);
            objGameCharacter.setMaxHealth(nerfHealth);
            objGameCharacter.setMaxShields(nerfShields);

            // Ubah atribut Value milik item menjadi 0
            this.setStrengthValue(0);
            this.setHealthValue(0);
            this.setShieldsValue(0);
        }
    }

    public void used(GameCharacter objGameCharacter) { // objGameCharacter yang di parsing akan berubah nilainya
        if (objGameCharacter == null) {
            System.out.println("Error! Parameter value is null!");
        } else {

            double xtraHealth = objGameCharacter.getHealth()
                    + (objGameCharacter.getMaxHealth() * this.getHealthMultiplier());

            if (xtraHealth > objGameCharacter.getMaxHealth()) {
                objGameCharacter.setHealth(objGameCharacter.getMaxHealth());
            } else {
                objGameCharacter.setHealth((int) xtraHealth);
            }
        }
    }

}
