package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionEnemy {
    private HashMap<String, Enemy> enemyHM = new HashMap<>();

    // Constructor
    public CollectionEnemy() {
        Enemy objEnemy01 = new Enemy("Mecha Minion", 3, 10, 60, 20, 24, 10);
        addEnemyHM("MechaMinion01", objEnemy01);

        Enemy objEnemy02 = new Enemy("Barret Autobot", 5, 23, 75, 27, 30, 15);
        addEnemyHM("BarretAutobot01", objEnemy02);
    }

    // Getter & Setter
    public HashMap<String, Enemy> getEnemyHM() {
        return enemyHM;
    }

    public void setEnemyHM(HashMap<String, Enemy> vEnemyHM) {
        this.enemyHM = vEnemyHM;
    }

    // Methods
    public void addEnemyHM(String enemyName, Enemy objEnemy) {
        enemyHM.put(enemyName, objEnemy);
    }

    public Enemy takeEnemyHM(String enemyName) {
        return getEnemyHM().get(enemyName);
    }

}
