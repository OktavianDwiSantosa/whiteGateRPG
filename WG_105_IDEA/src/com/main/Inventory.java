package com.main;

import com.globals.ItemName;

import java.util.ArrayList;

public class Inventory extends Thing {
    private Integer gold;
    private ArrayList<Item> objWeapons = new ArrayList<>();
    private ArrayList<Item> objAccessories = new ArrayList<>();
    private ArrayList<Item> objMedKits = new ArrayList<>();
    private ArrayList<Material> objMaterials = new ArrayList<>();

    // Constructor
    public Inventory(String vName, String vDescription) {
        super(vName, vDescription);
        this.gold = 0;
    }

    // Getter & Setter
    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer vGold) {
        this.gold = vGold;
    }

    public ArrayList<Item> getObjWeapons() {
        return objWeapons;
    }

    public void setObjWeapons(ArrayList<Item> vObjWeapons) {
        objWeapons = vObjWeapons;
    }

    public ArrayList<Item> getObjAccessories() {
        return objAccessories;
    }

    public void setObjAccessories(ArrayList<Item> vObjAccessories) {
        objAccessories = vObjAccessories;
    }

    public ArrayList<Item> getObjMedKits() {
        return objMedKits;
    }

    public void setObjMedKits(ArrayList<Item> vObjMedKits) {
        objMedKits = vObjMedKits;
    }

    public ArrayList<Material> getObjMaterials() {
        return objMaterials;
    }

    public void setObjMaterials(ArrayList<Material> vObjMaterials) {
        objMaterials = vObjMaterials;
    }

    // Methods
    public void addGold(Integer vGold) {
        this.gold += vGold;
    }

    public void addItem(Item objItem, ArrayList<Item> objItems) {
        objItems.add(objItem);
    }

    public void addMaterial(Material objMaterial) { // Menambahkan Material ke dalam ArrayList objMaterials
        objMaterials.add(objMaterial);
    }

    public void printGold() {
        System.out.println("\nYour gold is : " + gold);
    }

    public boolean printItemsInventory(ArrayList<Item> objItem, ItemName itemName) {
        boolean itemAvailable = true;
        if (objItem.isEmpty()) {
            System.out.println("\n======================================");
            System.out.println("         No " + itemName + " available");
            System.out.println("======================================");
            itemAvailable = false;
        } else {
            System.out.println("\n======================================");
            System.out.println("    This is your " + itemName + " Inventory");
            System.out.println("======================================");
            for (int i = 0; i < objItem.size(); i++) {
                System.out.println("\n" + itemName + " " + (i + 1));
                objItem.get(i).describe();
            }
            System.out.println("======================================");
        }
        return itemAvailable;
    }

    public void printMaterialsInventory(ArrayList<Material> objMaterial) {
        if (objMaterial.isEmpty()) {
            System.out.println("\n======================================");
            System.out.println("         No Material available");
            System.out.println("======================================");
        } else {
            System.out.println("\n======================================");
            System.out.println("    This is your Material Inventory");
            System.out.println("======================================");
            for (int i = 0; i < objMaterial.size(); i++) {
                System.out.println("\n" + objMaterial + " " + (i + 1));
                objMaterial.get(i).describe();
            }
            System.out.println("======================================");
        }
    }

    public Integer printWeaponsInventory(String heroName) {
        // untuk mencetak weapon milik hero

        int weaponAmount = 0;
        if (objWeapons.isEmpty()) {
            System.out.println("\n======================================");
            System.out.println("         No weapon available");
            System.out.println("======================================");
        } else {
            System.out.println("\n======================================");
            System.out.println("              Hero Weapon");
            System.out.println("======================================");

            for (Item objWeapon : objWeapons) {
                if (heroName.equals(objWeapon.getGameCharacter())) {
                    objWeapon.describe();
                    weaponAmount++;
                }
            }

            if (weaponAmount == 0) {
                System.out.println("\n          No weapon equipped\n");
            }

            System.out.println("======================================");
        }
        return weaponAmount;
    }

    public Integer printAccessoriesInventory(String heroName) {
        // untuk mencetak accessory milik hero

        int accessoryAmount = 0;
        if (objAccessories.isEmpty()) {
            System.out.println("\n======================================");
            System.out.println("        No accessory available");
            System.out.println("======================================");
        } else {
            System.out.println("\n======================================");
            System.out.println("             Hero Accessory");
            System.out.println("======================================");

            for (Item objAccessory : objAccessories) {
                if (heroName.equals(objAccessory.getGameCharacter())) {
                    objAccessory.describe();
                    accessoryAmount++;
                }
            }

            if (accessoryAmount == 0) {
                System.out.println("\n        No accessory equipped\n");
            }

            System.out.println("======================================");
        }
        return accessoryAmount;
    }

    public void printInventory() {
        System.out.println("\n======================================");
        System.out.println("       This is " + getName());
        System.out.println("======================================");

        printGold();
        printItemsInventory(objWeapons, ItemName.Weapon);
        printItemsInventory(objAccessories, ItemName.Accessory);
        printItemsInventory(objMedKits, ItemName.MedKit);
        printMaterialsInventory(objMaterials);
    }

    // tester
    public static void main(String[] args) {
        Inventory objInventory = new Inventory("", "");
        Weapon tempWeapon = new Weapon("Saber", "", "Saber", 3, 0.5);
        objInventory.addItem(tempWeapon, objInventory.getObjWeapons());
        // objInventory.printItemsInventory(objInventory.getObjWeapons(), "Weapon");
        objInventory.printItemsInventory(objInventory.getObjWeapons(), ItemName.Weapon);
    }
}