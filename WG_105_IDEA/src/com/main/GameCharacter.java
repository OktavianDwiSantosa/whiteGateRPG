package com.main;

import java.util.HashMap;

public class GameCharacter extends Thing {
    protected Integer level;
    protected Integer exp;
    protected Integer maxHealth;
    protected Integer health;
    protected Integer strength;
    protected Integer maxShields;
    protected Integer shields;
    protected HashMap<Integer, Skill> skillHM = new HashMap<>();

    // apakah sudah mengambil aksi ketika di battle system?
    protected boolean isAction;

    // Constructor
    public GameCharacter(String vName, String vDescription, Integer vLevel, Integer vExp, Integer vMaxHealth,
                         Integer vMaxShields, Integer vStrength) {
        super(vName, vDescription);
        this.level = vLevel;
        this.exp = vExp;
        this.maxHealth = vMaxHealth;
        this.health = vMaxHealth;
        this.maxShields = vMaxShields;
        this.shields = vMaxShields;
        this.strength = vStrength;
        this.isAction = false;
    }

    // Getter & Setter
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer vLevel) {
        this.level = vLevel;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer vExp) {
        this.exp = vExp;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer vMaxHealth) {
        this.maxHealth = vMaxHealth;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer vHealth) {
        this.health = vHealth;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer vStrength) {
        this.strength = vStrength;
    }

    public Integer getMaxShields() {
        return maxShields;
    }

    public void setMaxShields(Integer vMaxShields) {
        this.maxShields = vMaxShields;
    }

    public Integer getShields() {
        return shields;
    }

    public void setShields(Integer vShields) {
        this.shields = vShields;
    }

    public HashMap<Integer, Skill> getSkillHM() {
        return skillHM;
    }

    public void setSkillHM(HashMap<Integer, Skill> vSkillHM) {
        this.skillHM = vSkillHM;
    }

    public boolean isAction() {
        return isAction;
    }

    public void setAction(boolean vIsAction) {
        this.isAction = vIsAction;
    }

    // Methods
    @Override
    public void describe() {
        // Tampilkan seluruh nilai atribut dari objek Game Character
        super.describe();
        System.out.println("Level : " + level);
        System.out.println("EXP : " + exp);
        System.out.println("Max Health : " + maxHealth);
        System.out.println("Health : " + health);
        System.out.println("Strength : " + strength);
        System.out.println("Max Shields : " + maxShields);
        System.out.println("Shields : " + shields);
    }

    public void printSkill() {
        skillHM.forEach((key, value) -> System.out.println("[" + key + "] " + value.getName()));
    }

    public void printSkill(int heroIndex) {
        skillHM.forEach((key, value) -> {
            System.out.println("[" + heroIndex + key + "] " + value.getName());
            System.out.println("======================================");
            System.out.println("Type: " + value.getSkillType());
            System.out.println("Damage Deal: " + value.strengthValue);
            System.out.println("Defense Power: " + value.shieldsValue);
            System.out.println("Heal Power: " + value.healthValue);
            System.out.println("======================================");
        });
    }

    public void addSkillHM(Integer skillSlot, Skill objSkill) {
        // Menambahkan objek dari class Skill ke dalam hashmap skillHM
        objSkill.calculateSkill(this);
        skillHM.put(skillSlot, objSkill);
    }

    public Skill takeSkillHM(Integer skillSlot) {
        // Mengembalikan nilai berupa objek class Skill dari dalam hashmap skillHM
        // sesuai dengan Key dari objek tersebut (disini, Key dari objek Skill adalah
        // integer skillSlot)
        return getSkillHM().get(skillSlot);
    }

}
