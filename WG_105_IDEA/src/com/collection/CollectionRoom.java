package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionRoom {
    private HashMap<String, Room> roomHM = new HashMap<>();

    // Constructor
    public CollectionRoom() {
        Room objRoom01 = new Room("Room 1", "This is the forest");
        addRoomHM("Room01", objRoom01);

        Room objRoom02 = new Room("Room 2", "You're at front of cave");
        addRoomHM("Room02", objRoom02);
    }

    // Setter & Getter
    public HashMap<String, Room> getRoomHM() {
        return roomHM;
    }

    public void setRoomHM(HashMap<String, Room> vRoomHM) {
        this.roomHM = vRoomHM;
    }

    // Methods
    public void addRoomHM(String roomName, Room objRoom) {
        roomHM.put(roomName, objRoom);
    }

    public Room takeRoomHM(String roomName) {
        return getRoomHM().get(roomName);
    }

}
