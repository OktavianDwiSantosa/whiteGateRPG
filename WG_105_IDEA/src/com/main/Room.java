package com.main;

import java.util.ArrayList;
import java.util.HashMap;

import com.globals.Direction;

public class Room extends Thing {
    private ArrayList<Enemy> objEnemies = new ArrayList<>();
    private ArrayList<Box> objBoxes = new ArrayList<>();
    private HashMap<Direction, Room> nextRoomHM = new HashMap<>();

    // Constructor
    public Room(String vName, String vDescription) {
        super(vName, vDescription);
    }

    // Getter & Setter
    public ArrayList<Enemy> getObjEnemies() {
        return objEnemies;
    }

    public void setObjEnemies(ArrayList<Enemy> vObjEnemies) {
        this.objEnemies = vObjEnemies;
    }

    public ArrayList<Box> getObjBoxes() {
        return objBoxes;
    }

    public void setObjBoxes(ArrayList<Box> vObjBoxes) {
        this.objBoxes = vObjBoxes;
    }

    public HashMap<Direction, Room> getNextRoomHM() {
        return nextRoomHM;
    }

    public void setNextRoomHM(HashMap<Direction, Room> vNextRoomHM) {
        this.nextRoomHM = vNextRoomHM;
    }

    // Method
    @Override
    public void describe() {
        super.describe();

        if (objEnemies.isEmpty()) {
            System.out.println("\nThere is no available enemy");
        } else {
            System.out.printf("\nThere are %d enemies\n", objEnemies.size());
        }

        if (objBoxes.isEmpty()) {
            System.out.println("There is no available box\n");
        } else {
            System.out.printf("There are %d boxes\n\n", objBoxes.size());
        }
    }

    public void printBoxes() {
        for (int i = 0; i < objBoxes.size(); i++) {
            System.out.print("\n======================================");
            System.out.println("\nBox " + (i + 1));
            objBoxes.get(i).describe();
            System.out.println("======================================");
        }
    }

    public void addEnemy(Enemy objEnemy) {
        objEnemies.add(objEnemy);
    }

    public void addBox(Box objBox) {
        objBoxes.add(objBox);
    }

    public void printNextRoomHM() {
        nextRoomHM.forEach((k, v) -> {
            System.out.println("[" + k + "] " + v.getName());
        });
    }

    public void addNextRoomHM(Direction roomDirection, Room objRoom) {
        nextRoomHM.put(roomDirection, objRoom);
    }

}
