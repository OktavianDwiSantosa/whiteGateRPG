package com.main;

public class Box extends Thing {

    private Integer boxGold;
    private Weapon objWeapon;
    private Accessory objAccessory;
    private MedKit objMedKit;
    private Material objMaterial;
    private boolean isOpened;

    // Constructor
    public Box(String vName, Integer vBoxGold) {
        super(vName, "");
        this.boxGold = vBoxGold;
    }

    // Getter & Setter
    public Integer getBoxGold() {
        return boxGold;
    }

    public void setBoxGold(Integer vBoxGold) {
        this.boxGold = vBoxGold;
    }

    public Weapon getObjWeapon() {
        return objWeapon;
    }

    public void setObjWeapon(Weapon vObjWeapon) {
        this.objWeapon = vObjWeapon;
    }

    public Accessory getObjAccessory() {
        return objAccessory;
    }

    public void setObjAccessory(Accessory vObjAccessory) {
        this.objAccessory = vObjAccessory;
    }

    public MedKit getObjMedKit() {
        return objMedKit;
    }

    public void setObjMedKit(MedKit vObjMedKit) {
        objMedKit = vObjMedKit;
    }

    public Material getObjMaterial() {
        return objMaterial;
    }

    public void setObjMaterial(Material vObjMaterial) {
        this.objMaterial = vObjMaterial;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean vOpened) {
        isOpened = vOpened;
    }

    // Methods
    public void printBox() {
        super.describe();
        System.out.println("Box Gold : " + boxGold);

        if (objWeapon != null) {
            System.out.println("================================================");
            System.out.println("         Available weapon in this box");
            System.out.println("================================================");
            objWeapon.describe();
            System.out.println("================================================");
        }

        if (objAccessory != null) {
            System.out.println("================================================");
            System.out.println("        Available accessory in this box");
            System.out.println("================================================");
            objAccessory.describe();
            System.out.println("================================================");
        }

        if (objMedKit != null) {
            System.out.println("================================================");
            System.out.println("      Available recovery item in this box");
            System.out.println("================================================");
            objMedKit.describe();
            System.out.println("================================================");
        }

        if (objMaterial != null) {
            System.out.println("================================================");
            System.out.println("        Available material in this box");
            System.out.println("================================================");
            objMaterial.describe();
            System.out.println("================================================");
        }
    }

    // memindahkan objek yang ada di dalam box ke dalam inventory
    public void opened(Inventory objInventory) {
        objInventory.addGold(boxGold);
        objInventory.addItem(objAccessory, objInventory.getObjAccessories());
        objInventory.addItem(objWeapon, objInventory.getObjWeapons());
        objInventory.addItem(objMedKit, objInventory.getObjMedKits());
        objInventory.addMaterial(objMaterial);

        System.out.printf("\nYou have been opened the %s!\n", this.getName());
        printBox();
    }
}
