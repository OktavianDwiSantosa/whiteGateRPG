package com.collection;

import com.main.*;

import java.util.HashMap;

public class CollectionSkill {
    private HashMap<String, Skill> skillHM = new HashMap<>();

    // Constructor
    public CollectionSkill() {
        Skill heroSkill01 = new Skill("Braustex", "", "Light", 1.2, 15);
        addSkillHM("Elon01", heroSkill01);

        Skill heroSkill02 = new Skill("Vludwix", "", "Normal", 1.5, 30);
        addSkillHM("Elon02", heroSkill02);

        Skill heroSkill03 = new Skill("Fatalities", "", "Heavy", 2.0, 45);
        addSkillHM("Elon03", heroSkill03);

        Skill enemySkill01 = new Skill("Fire!", "", "Light", 1.2, 15);
        addSkillHM("MechaMinion01", enemySkill01);

        Skill enemySkill02 = new Skill("Blaster", "", "Normal", 1.5, 30);
        addSkillHM("MechaMinion02", enemySkill02);

        Skill enemySkill03 = new Skill("Power Shot", "", "Heavy", 2.0, 45);
        addSkillHM("MechaMinion03", enemySkill03);

        Skill enemySkill04 = new Skill("Slash!", "", "Light", 1.2, 15);
        addSkillHM("BarretAutobot01", enemySkill04);

        Skill enemySkill05 = new Skill("High Slash", "", "Normal", 1.5, 30);
        addSkillHM("BarretAutobot02", enemySkill05);

        Skill enemySkill06 = new Skill("Cut the Body!", "", "Heavy", 2.0, 45);
        addSkillHM("BarretAutobot03", enemySkill06);
    }

    // Getter & Setter
    public HashMap<String, Skill> getSkillHM() {
        return skillHM;
    }

    public void setSkillHM(HashMap<String, Skill> vSkillHM) {
        this.skillHM = vSkillHM;
    }

    // Methods
    public void addSkillHM(String characterName, Skill objSkill) {
        skillHM.put(characterName, objSkill);
    }

    public Skill takeSkillHM(String characterName) {
        return getSkillHM().get(characterName);
    }

}
