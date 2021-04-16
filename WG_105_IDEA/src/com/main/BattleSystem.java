package com.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BattleSystem {
    Scanner sc = new Scanner(System.in);
    private Integer turn;

    // untuk menyimpan data arraylist hero & enemy yang diambil dari gameEngine
    private ArrayList<GameCharacter> objHeroes = new ArrayList<>();
    private ArrayList<GameCharacter> objEnemies = new ArrayList<>();
    private ArrayList<Skill> readySkill = new ArrayList<>();

    // Getter & Setter
    public Integer getTurn() { return turn; }

    public void setTurn(Integer vTurn) { turn = vTurn; }

    public ArrayList<GameCharacter> getObjHeroes() { return objHeroes; }

    public void setObjHeroes(ArrayList<GameCharacter> vObjHeroes) { objHeroes = vObjHeroes; }

    public ArrayList<GameCharacter> getObjEnemies() { return objEnemies; }

    public void setObjEnemies(ArrayList<GameCharacter> vObjEnemies) { objEnemies = vObjEnemies; }

    public ArrayList<Skill> getReadySkill() { return readySkill; }

    public void setReadySkill(ArrayList<Skill> vReadySkill) { readySkill = vReadySkill; }

    // Methods
    public void addHeroes(GameCharacter vObjHero) { objHeroes.add(vObjHero); }

    public void addEnemies(GameCharacter vObjEnemy) { objEnemies.add(vObjEnemy); }

    public void addReadySkill(Skill tempSkill) {
        readySkill.add(tempSkill);
    }

    public void printHeroes() {
        int i = 1;

        for (GameCharacter objHero : objHeroes) {
            System.out.println("\n===============");
            System.out.print(objHero.getName());

            if (objHero.isAction()) {
                System.out.println(" -> has taken an action");
            } else {
                System.out.println();
            }

            System.out.println("===============");

            // cetak skill-skill milik objCharacter
            objHero.printSkill(i);
            i++;
        }
    }

    public GameCharacter target(ArrayList<GameCharacter> arrObjTarget) {
        int i = 1;
        int selectTarget;

        for (GameCharacter objTarget : arrObjTarget) {
            System.out.println("\n===============");
            System.out.println("[" + i + "] " + objTarget.getName());
            System.out.println("===============");
            i++;
        }

        System.out.print("Choose your target: ");
        selectTarget = sc.nextInt();

        return arrObjTarget.get(selectTarget - 1);
    }

    public Skill selectTarget(Skill tempSkill) {
        GameCharacter target;
        // tampilkan pilihan target untuk hero yang sedang melakukan aksi
        if (tempSkill.isTargetFoe()) {
            target = target(objEnemies);
        } else {
            target = target(objHeroes);
        }
        // set target untuk skill
        tempSkill.setTempTarget(target);

        return tempSkill;
    }

    public void heroMenu() {
        int arrSize = objHeroes.size();
        int i = 0;

        while (i < arrSize) {
            System.out.println("\n======================================");
            System.out.println("               Your Hero");
            System.out.println("======================================");
            printHeroes();
            System.out.print("Select hero: ");

            GameCharacter tempHero;
            Skill tempSkill;

            try {
                String userChoice = sc.next();

                // ambil digit pertama, asumsikan jumlah hero di dalam array tidak lebih dari 10
                int hero = Integer.parseInt(userChoice.substring(0, 1));
                // ambil digit kedua, asumsikan jumlah skill di dalam array tidak lebih dari 10
                int skill = Integer.parseInt(userChoice.substring(1, 2));

                if (!objHeroes.get((hero - 1)).isAction()) {
                    tempHero = objHeroes.get((hero - 1));
                    tempSkill = tempHero.takeSkillHM(skill);

                    // pilih target skill, kemudian tambahkan ke arr readySkill
                    addReadySkill(selectTarget(tempSkill));
                    // jatah yang sudah diambil bertambah
                    i++;
                } else {
                    System.out.println("\nSelect another hero!");
                    System.out.println("This hero has already been take an action!");
                    // heroMenu();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Your input doesn't valid!");
                // bersihkan scanner dengan cara membuat objek baru;
                sc = new Scanner(System.in);
                // heroMenu();
            }
        }
    }

    public void enemyMenu() {
        int arrSize = objEnemies.size();
        int i = 0;

        while (i < arrSize) {
            GameCharacter tempEnemy;
            Skill tempSkill;

            for (GameCharacter objEnemy : objEnemies) {
                // set nilai max berdasarkan banyaknya skill milik objEnemy
                int max = objEnemy.getSkillHM().size();

                tempEnemy = objEnemies.get((i));
                // lakukan math random dalam range (1 - max) untuk memilih skill enemy
                tempSkill = tempEnemy.takeSkillHM((int) ((Math.random() * (max - 1)) + 1));

                // pilih target skill, kemudian tambahkan ke arr readySkill
                addReadySkill(selectTarget(tempSkill));
                // jatah yang sudah diambil bertambah
                i++;
            }
        }
    }

    public void calculateBattle(ArrayList<Skill> vReadySkill) {
        /* Alur method calculateBattle
         * 1. Sorting array readySkill agar diurutkan secara ascending
         *    berdasarkan atribut timestamp
         * 2. Ambil data dari readySkill
         * 3. Eksekusi method setiap objSkill
         */
//        readySkill.sort();
        readySkill.sort(Comparator.comparing(Skill::getTimestamp));
        int i = 1;

        System.out.println("readySkill : ");
        for (Skill objSkill : readySkill) {
            System.out.println("Skill " + i);
            System.out.println("Target : " + objSkill.getTempTarget().getName());
            System.out.println("Timestamp : " + objSkill.getTimestamp());
            i++;
        }
    }

    public void startBattle() {
        turn = 1;
        boolean isBattleStopped = false;

        while (!isBattleStopped) {
            // enemy
            // set setiap enemy di dalam array dengan looping agar menggunakan skill
            enemyMenu();

            // user
            // 1. pilih hero
            // 2. pilih aksi hero -> aksi hero memiliki atribut "Value",
            //    untuk menampung data damage, heal, atau pun shield.
            // 3. pilih salah satu enemy atau hero sebagai target skill
            // 4. looping sampai semua hero memilih skill
            heroMenu();

            calculateBattle(readySkill);
            turn++;
            isBattleStopped = true;
        }
    }

    // tester
    public static void main(String[] args) {
        Hero objHero1 = new Hero("Udin", 50, 30, 40, "Saber");
        Hero objHero2 = new Hero("Budi", 40, 30, 60, "Projectile");
        Enemy objEnemy1 = new Enemy("Minibot M1", 3, 10, 50, 30, 20, 5);
        Enemy objEnemy2 = new Enemy("Minibot M2", 3, 11, 55, 35, 15, 5);

        Skill udin01 = new Skill("Braustex", "", "Light", 1.2, 15);
        objHero1.addSkillHM(1, udin01);

        Skill budi01 = new Skill("Cut", "", "Normal", 1.5, 30);
        objHero1.addSkillHM(1, budi01);

        Skill minibot01 = new Skill("Fire!", "", "Light", 1.2, 20);
        objEnemy1.addSkillHM(1, minibot01);

        Skill minibot02 = new Skill("Cut the Body!", "", "Heavy", 2.0, 45);
        objEnemy2.addSkillHM(1, minibot02);

        BattleSystem objBattleSystem = new BattleSystem();
        objBattleSystem.addHeroes(objHero1);
        objBattleSystem.addHeroes(objHero2);
        objBattleSystem.addEnemies(objEnemy1);
        objBattleSystem.addEnemies(objEnemy2);

        objBattleSystem.startBattle();
//        objBattleSystem.printHeroes();


    }

}