package com.main;

import com.collection.*;
import com.globals.Direction;
import com.userinterface.GUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameEngine { // Main class
    Scanner sc = new Scanner(System.in);
    private boolean isStop = false;

    // Instansiasi collection
    // ini hanya sebagai sumber data
    public CollectionSkill skillCollection;
    public CollectionHero heroCollection;
    public CollectionEnemy enemyCollection;
    public CollectionMedKit recoveryItemCollection;
    public CollectionWeapon weaponCollection;
    public CollectionAccessory accessoryCollection;
    public CollectionMaterial materialCollection;
    public CollectionBox boxCollection;
    public CollectionRoom roomCollection;
    public CollectionChapter chapterCollection;

    // Atribut tampung yang akan digunakan selama permainan berjalan
    private HashMap<String, Skill> skillHM;
    private HashMap<String, Hero> heroHM;
    private HashMap<String, Enemy> enemyHM;
    private HashMap<String, MedKit> recoveryItemHM;
    private HashMap<String, Weapon> weaponHM;
    private HashMap<String, Accessory> accessoryHM;
    private HashMap<String, Material> materialHM;
    private HashMap<String, Box> boxHM;
    private HashMap<String, Room> roomHM;
    private HashMap<Integer, Chapter> chapterHM;

    // collection untuk hero yang telah didapatkan user
    private ArrayList<Hero> userHeroes = new ArrayList<>();

    // collection untuk min 1 hero & max 3 hero yang akan bertarung
    private ArrayList<Hero> activeHeroes = new ArrayList<>();

    // inventory milik user (dipakai semua hero)
    private Inventory userInventory;
    private BattleSystem objBattleSystem;

    // Contructor
    public GameEngine() {
        skillCollection = new CollectionSkill();
        heroCollection = new CollectionHero();
        enemyCollection = new CollectionEnemy();
        recoveryItemCollection = new CollectionMedKit();
        weaponCollection = new CollectionWeapon();
        accessoryCollection = new CollectionAccessory();
        materialCollection = new CollectionMaterial();
        boxCollection = new CollectionBox();
        roomCollection = new CollectionRoom();
        chapterCollection = new CollectionChapter();

        skillHM = skillCollection.getSkillHM();
        heroHM = heroCollection.getHeroHM();
        enemyHM = enemyCollection.getEnemyHM();
        recoveryItemHM = recoveryItemCollection.getRecoveryItemHM();
        weaponHM = weaponCollection.getWeaponHM();
        accessoryHM = accessoryCollection.getAccessoryHM();
        materialHM = materialCollection.getMaterialHM();
        boxHM = boxCollection.getBoxHM();
        roomHM = roomCollection.getRoomHM();
        chapterHM = chapterCollection.getChapterHM();

        objBattleSystem = new BattleSystem();
        userInventory = new Inventory("User Inventory", "");

        // init
        // Menambahkan skill untuk objHero dengan nama Elon
        heroHM.get("Elon").addSkillHM(1, skillHM.get("Elon01"));
        heroHM.get("Elon").addSkillHM(2, skillHM.get("Elon02"));
        heroHM.get("Elon").addSkillHM(3, skillHM.get("Elon03"));
        heroHM.get("Elon").setActive(true);
        activeHeroes.add(heroHM.get("Elon"));
        userHeroes.add(heroHM.get("Elon"));

        enemyHM.get("MechaMinion01").addMaterial(materialHM.get("Steel01"));
        enemyHM.get("MechaMinion01").addSkillHM(1, skillHM.get("MechaMinion01"));
        enemyHM.get("MechaMinion01").addSkillHM(2, skillHM.get("MechaMinion02"));
        enemyHM.get("MechaMinion01").addSkillHM(3, skillHM.get("MechaMinion03"));

        enemyHM.get("BarretAutobot01").addMaterial(materialHM.get("Copper01"));
        enemyHM.get("BarretAutobot01").addSkillHM(1, skillHM.get("BarretAutobot01"));
        enemyHM.get("BarretAutobot01").addSkillHM(2, skillHM.get("BarretAutobot02"));
        enemyHM.get("BarretAutobot01").addSkillHM(3, skillHM.get("BarretAutobot03"));

        boxHM.get("Silver01").setObjWeapon(weaponHM.get("LongSword"));

        roomHM.get("Room01").addEnemy(enemyHM.get("MechaMinion01"));
        roomHM.get("Room01").addBox(boxHM.get("Steel01"));
        roomHM.get("Room01").addBox(boxHM.get("Silver01"));
        roomHM.get("Room01").addNextRoomHM(Direction.D, roomHM.get("Room02"));

        roomHM.get("Room02").addEnemy(enemyHM.get("BarretAutobot01"));
        roomHM.get("Room02").addNextRoomHM(Direction.A, roomHM.get("Room01"));

        chapterHM.get(1).addRoomHM(1, roomHM.get("Room01"));
    }

    // Getter & Setter
    public boolean isStop() {
        return isStop;
    }

    public void setStop(boolean vIsStop) {
        this.isStop = vIsStop;
    }

    public HashMap<String, Skill> getSkillHM() {
        return skillHM;
    }

    public void setSkillHM(HashMap<String, Skill> vSkillHM) {
        this.skillHM = vSkillHM;
    }

    public HashMap<String, Hero> getHeroHM() {
        return heroHM;
    }

    public void setHeroHM(HashMap<String, Hero> vHeroHM) {
        this.heroHM = vHeroHM;
    }

    public HashMap<String, Enemy> getEnemyHM() {
        return enemyHM;
    }

    public void setEnemyHM(HashMap<String, Enemy> vEnemyHM) {
        this.enemyHM = vEnemyHM;
    }

    public HashMap<String, MedKit> getRecoveryItemHM() {
        return recoveryItemHM;
    }

    public void setRecoveryItemHM(HashMap<String, MedKit> vRecoveryItemHM) {
        this.recoveryItemHM = vRecoveryItemHM;
    }

    public HashMap<String, Weapon> getWeaponHM() {
        return weaponHM;
    }

    public void setWeaponHM(HashMap<String, Weapon> vWeaponHM) {
        this.weaponHM = vWeaponHM;
    }

    public HashMap<String, Accessory> getAccessoryHM() {
        return accessoryHM;
    }

    public void setAccessoryHM(HashMap<String, Accessory> vAccessoryHM) {
        this.accessoryHM = vAccessoryHM;
    }

    public HashMap<String, Material> getMaterialHM() {
        return materialHM;
    }

    public void setMaterialHM(HashMap<String, Material> vMaterialHM) {
        this.materialHM = vMaterialHM;
    }

    public HashMap<String, Box> getBoxHM() {
        return boxHM;
    }

    public void setBoxHM(HashMap<String, Box> vBoxHM) {
        this.boxHM = vBoxHM;
    }

    public HashMap<String, Room> getRoomHM() {
        return roomHM;
    }

    public void setRoomHM(HashMap<String, Room> vRoomHM) {
        this.roomHM = vRoomHM;
    }

    public HashMap<Integer, Chapter> getChapterHM() {
        return chapterHM;
    }

    public void setChapterHM(HashMap<Integer, Chapter> vChapterHM) {
        this.chapterHM = vChapterHM;
    }

    public ArrayList<Hero> getUserHeroes() {
        return userHeroes;
    }

    public void setUserHeroes(ArrayList<Hero> vUserHeroes) {
        this.userHeroes = vUserHeroes;
    }

    public ArrayList<Hero> getActiveHeroes() {
        return activeHeroes;
    }

    public void setActiveHeroes(ArrayList<Hero> vActiveHeroes) {
        this.activeHeroes = vActiveHeroes;
    }

    public Inventory getObjInventory() {
        return userInventory;
    }

    public void setObjInventory(Inventory vObjInventory) {
        this.userInventory = vObjInventory;
    }

    public BattleSystem getObjBattleSystem() {
        return objBattleSystem;
    }

    public void setObjBattleSystem(BattleSystem vObjBattleSystem) {
        this.objBattleSystem = vObjBattleSystem;
    }

    // Methods
    public static void main(String[] args) { // Main methods
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        // nanti diupdate agar ada menu new game dan load game
        // ini masih new game
        objGameEngine.start();
    }

    private void selectChapter() {
        System.out.println("\n======================================");
        System.out.println(" List of Chapter");
        System.out.println("======================================");
        chapterCollection.printChapter();
        System.out.println("======================================");
        System.out.print("Choose a chapter : ");
        int chapterChoice = sc.nextInt();

        // inisiasi chapter aktif semua objek hero di chapter ke-1
        // nanti diupdate agar bisa load chapter aktif dari savefile.txt
        Hero.setActiveChapter(chapterCollection.takeChapterHM(chapterChoice));

        // inisiasi ruangan aktif semua objek hero di ruangan ke-1, chapter pilihan user
        // nanti diupdate agar bisa load ruangan aktif dari savefile.txt
        Hero.setActiveRoom(Hero.getActiveChapter().takeRoomHM(1));
    }

    private void start() {
        System.out.println("\n======================================");
        System.out.println("           Starting the game...");
        System.out.println("======================================");

        selectChapter();
        while (!isStop) {
            GUI.adventureMenu(this);
        }
    }

}
