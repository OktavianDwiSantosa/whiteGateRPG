package com.main;

import java.util.HashMap;

public class Chapter extends Thing {

    private HashMap<Integer, Room> roomHM = new HashMap<>();

    // Constructor
    public Chapter(String vName) {
        super(vName, "");
    }

    // Getter & Setter
    public HashMap<Integer, Room> getRoomHM() {
        return roomHM;
    }

    public void setRoomHM(HashMap<Integer, Room> vRoomHM) {
        this.roomHM = vRoomHM;
    }

    // Methods
    public void printChapterRooms() {
        System.out.println("\n======================================");
        System.out.println("           Available Rooms");
        System.out.println("======================================");
        roomHM.forEach((k, v) -> v.describe());
    }

    public void addRoomHM(Integer roomID, Room objRoom) {
        roomHM.put(roomID, objRoom);
    }

    public Room takeRoomHM(Integer roomID) {
        return getRoomHM().get(roomID);
    }
}
