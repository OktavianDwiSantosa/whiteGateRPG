package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionBox {
    private HashMap<String, Box> boxHM = new HashMap<>();

    // Constructor
    public CollectionBox() {
        Box objBox01 = new Box("Steel Box", 10);
        addBoxHM("Steel01", objBox01);

        Box objBox02 = new Box("Silver Box", 50);
        addBoxHM("Silver01", objBox02);
    }

    // Getter & Setter
    public HashMap<String, Box> getBoxHM() {
        return boxHM;
    }

    public void setBoxHM(HashMap<String, Box> vBoxHM) {
        this.boxHM = vBoxHM;
    }

    // Methods
    public void addBoxHM(String boxName, Box objBox) {
        boxHM.put(boxName, objBox);
    }

    public Box takeBoxHM(String boxName) {
        return getBoxHM().get(boxName);
    }

}
