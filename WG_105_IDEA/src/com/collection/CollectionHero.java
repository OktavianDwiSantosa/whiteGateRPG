package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionHero {
    private HashMap<String, Hero> heroHM = new HashMap<>();

    // Constructor
    public CollectionHero() {
        Hero objHero01 = new Hero("Elon", 50, 50, 23, "Sword");
        addHeroHM("Elon", objHero01);

        Hero objHero02 = new Hero("Farlan", 45, 30, 25, "Projectile");
        addHeroHM("Farlan", objHero02);

        Hero objHero03 = new Hero("Jojo", 60, 40, 20, "Gauntlet");
        addHeroHM("Jojo", objHero03);

        Hero objHero04 = new Hero("Raikou", 55, 45, 21, "Saber");
        addHeroHM("Raikou", objHero04);

        Hero objHero05 = new Hero("Tony", 40, 25, 30, "Cyberware");
        addHeroHM("Tony", objHero05);
    }

    // Getter & Setter
    public HashMap<String, Hero> getHeroHM() {
        return heroHM;
    }

    public void setHeroHM(HashMap<String, Hero> vHeroHM) {
        this.heroHM = vHeroHM;
    }

    // Methods
    public void addHeroHM(String heroName, Hero objHero) {
        heroHM.put(heroName, objHero);
    }

    public Hero takeHeroHM(String heroName) {
        return getHeroHM().get(heroName);
    }

}
