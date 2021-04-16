package com.main;

// import java.util.HashMap;

import com.globals.Direction;

public class Hero extends GameCharacter {
    private boolean isActive;
    private String weaponType;

    // dibuat static agar semua objek hero memiliki ruangan aktif yang sama
    private static Room activeRoom;
    private static Chapter activeChapter;

    // Constructor
    public Hero(String vName, Integer vMaxHealth, Integer vMaxShields, Integer vStrength, String vWeaponType) {
        super(vName, "", 1, 1, vMaxHealth, vMaxShields, vStrength);
        this.isActive = false;
        this.weaponType = vWeaponType;
    }

    // Getter & Setter
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean vIsActive) {
        this.isActive = vIsActive;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String vWeaponType) {
        this.weaponType = vWeaponType;
    }

    public static Room getActiveRoom() {
        return activeRoom;
    }

    public static void setActiveRoom(Room vActiveRoom) {
        activeRoom = vActiveRoom;
    }

    public static Chapter getActiveChapter() {
        return activeChapter;
    }

    public static void setActiveChapter(Chapter vActiveChapter) {
        activeChapter = vActiveChapter;
    }

    // Methods
    @Override
    public void describe() { // Method overidding, tapi tetap membawa method printStats milik superclass
        System.out.println("\n======================================");
        System.out.println("            Hero status");
        System.out.println("======================================");
        super.describe(); // Ambil method milik GameCharacter
        System.out.println("Weapon Type : " + weaponType); // Tambahkan hasil keluaran dengan perintah ini
        System.out.println("======================================\n");
    }

    public static void moveToNextRoom(Direction userChoice) {

        if (activeRoom != null) {
            if (activeRoom.getNextRoomHM().get(userChoice) != null) {
                setActiveRoom(activeRoom.getNextRoomHM().get(userChoice));
                System.out.println("\nYou are moving into the next room...");
            } else {
                System.out.println("\nThere is no room!");
            }
        } else {
            System.out.println("Error! Active Room is null!\n");
        }
    }

}