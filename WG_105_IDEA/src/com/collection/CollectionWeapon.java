package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionWeapon {
    private HashMap<String, Weapon> weaponHM = new HashMap<>();

    // Constructor
    public CollectionWeapon() {
        // Weapon untuk heroElon
        Weapon objWeapon01 = new Weapon("Long Sword", "", "Sword", 2, 0.5);
        addWeaponHM("LongSword", objWeapon01);

        Weapon objWeapon02 = new Weapon("Short Sword", "", "Sword", 1, 0.3);
        addWeaponHM("ShortSword", objWeapon02);

        // Weapon untuk heroRhys
        Weapon objWeapon03 = new Weapon("Small Cannon", "", "Projectile", 1, 0.3);
        addWeaponHM("SmallCannon", objWeapon03);

        // Weapon untuk heroJojo
        Weapon objWeapon04 = new Weapon("Iron Head", "", "Gauntlet", 1, 0.3);
        addWeaponHM("IronHead", objWeapon04);

        // Weapon untuk heroAkio
        Weapon objWeapon05 = new Weapon("Light Saber", "", "Saber", 1, 0.3);
        addWeaponHM("Lightsaber", objWeapon05);

        // Weapon untuk heroTony
        Weapon objWeapon06 = new Weapon("Jammer Dust", "", "Cyberware", 1, 0.3);
        addWeaponHM("JammerDust", objWeapon06);
    }

    // Getter & Setter
    public HashMap<String, Weapon> getWeaponHM() {
        return weaponHM;
    }

    public void setWeaponHM(HashMap<String, Weapon> vWeaponHM) {
        this.weaponHM = vWeaponHM;
    }

    // Methods
    public void addWeaponHM(String weaponName, Weapon objWeapon) {
        weaponHM.put(weaponName, objWeapon);
    }

    public Weapon takeWeaponHM(String weaponName) {
        return getWeaponHM().get(weaponName);
    }

}
