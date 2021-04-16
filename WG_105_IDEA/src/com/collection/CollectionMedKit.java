package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionMedKit {
    private HashMap<String, MedKit> recoveryItemHM = new HashMap<>();

    // Constructor
    public CollectionMedKit() {
        MedKit objRecoveryItem01 = new MedKit("Small Health Kit",
                "This health kit give a small amount of health to Hero.", 0.25);
        addRecoveryItemHM("SmallHK01", objRecoveryItem01);

        MedKit objRecoveryItem02 = new MedKit("Medium Health Kit",
                "This health kit give a plenty amount of health to Hero.", 0.5);
        addRecoveryItemHM("SmallHK01", objRecoveryItem02);

        MedKit objRecoveryItem03 = new MedKit("Full Health Kit",
                "This health kit makes Hero health goes to MAX!", 1.0);
        addRecoveryItemHM("SmallHK01", objRecoveryItem03);
    }

    // Getter & Setter
    public HashMap<String, MedKit> getRecoveryItemHM() {
        return recoveryItemHM;
    }

    public void setRecoveryItemHM(HashMap<String, MedKit> vRecoveryItemHM) {
        this.recoveryItemHM = vRecoveryItemHM;
    }

    // Methods
    public void addRecoveryItemHM(String recoveryItemName, MedKit objRecoveryItem) {
        recoveryItemHM.put(recoveryItemName, objRecoveryItem);
    }

    public MedKit takeRecoveryItemHM(String recoveryItemName) {
        return getRecoveryItemHM().get(recoveryItemName);
    }

}
