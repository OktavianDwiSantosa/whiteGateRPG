package com.userinterface;

import com.globals.Direction;
import com.globals.ItemName;
import com.main.GameEngine;
import com.main.Hero;
import com.main.Inventory;

import java.util.Scanner;

public class GUI {
    static Scanner sc = new Scanner(System.in);

    // Method
    public static void printArrHero(String noLegend, GameEngine objGameEngine) {
        System.out.println("\n======================================");
        System.out.println("             Your Heroes");
        System.out.println("======================================");
        // tampilkan isi array userHeroes tanpa tulisan " -> Active Party"
        // digunakan ketika menampilkan list hero di luar menu editActiveParty
        int i = 1;
        for (Hero objHero : objGameEngine.getUserHeroes()) {
            System.out.println("[" + i + "] " + objHero.getName());
            i++;
        }
        System.out.println("======================================");
    }

    public static void printArrHero(GameEngine objGameEngine, String useLegend) {
        System.out.println("\n======================================");
        System.out.println("             Your Heroes");
        System.out.println("======================================");

        int i = 1;
        for (Hero objHero : objGameEngine.getUserHeroes()) {
            System.out.println("[" + i + "] " + objHero.getName());
            if (objHero.isActive()) {
                System.out.println(" -> Active Party");
            }
            i++;
        }
        System.out.println("======================================");
    }

    public static void printArrHero(GameEngine objGameEngine) {
        System.out.println("\n======================================");
        System.out.println("             Active Party");
        System.out.println("======================================");
        // tampilkan isi array activeHeroes
        int i = 1;
        for (Hero objHero : objGameEngine.getActiveHeroes()) {
            System.out.println("[" + i + "] " + objHero.getName());
            i++;
        }
        System.out.println("======================================");
    }

    public static void addActiveParty(GameEngine objGameEngine, int selectHero) {
        if (objGameEngine.getUserHeroes().get((selectHero - 1)).isActive()) {
            // jika hero yang dipilih sudah ada di dalam active party
            System.out.println("\nPlease select hero that's not in active party!\n");
        } else {
            if (objGameEngine.getActiveHeroes().size() == 3) {
                System.out.println("\nMaximum hero members in active party is only 3 heroes\n");
            } else {
                System.out.println("\n" + objGameEngine.getUserHeroes().get((selectHero - 1))
                        + " successfully added to active party!\n");

                // ubah atribut isActive objHero menjadi true,
                // setelah itu add objHero ke dalam array activeHeroes
                objGameEngine.getUserHeroes().get((selectHero - 1)).setActive(true);
                objGameEngine.getActiveHeroes().add(objGameEngine.getUserHeroes().get((selectHero - 1)));
            }
        }
    }

    public static void delActiveParty(GameEngine objGameEngine, int selectHero) {
        if (objGameEngine.getActiveHeroes().size() == 1) {
            System.out.println("\nYou can't remove a hero! At least there's one hero in active party\n");
        } else {
            System.out.println("\n" + objGameEngine.getUserHeroes().get((selectHero - 1))
                    + " successfully removed to active party!\n");

            // ubah atribut isActive objHero menjadi false,
            // setelah itu remove objHero dari array activeHeroes
            objGameEngine.getActiveHeroes().get((selectHero - 1)).setActive(false);
            objGameEngine.getActiveHeroes().remove((selectHero - 1));
        }
    }

    public static void editActiveParty(GameEngine objGameEngine) {
        System.out.println("\n======================================");
        System.out.println("           Edit Active Party");
        System.out.println("======================================");
        System.out.println("[1] Add hero to active party");
        System.out.println("[2] Remove hero from active party");
        System.out.println("======================================");
        System.out.print("Choose your action: ");

        int userAction = sc.nextInt();
        int selectHero;
        switch (userAction) {
            case 1 -> {
                printArrHero(objGameEngine, "useLegend");
                System.out.print("Choose hero to be added into active party: ");
                selectHero = sc.nextInt();
                addActiveParty(objGameEngine, selectHero);
            }
            case 2 -> {
                printArrHero(objGameEngine);
                System.out.print("Choose hero to be removed from active party: ");
                selectHero = sc.nextInt();
                delActiveParty(objGameEngine, selectHero);
            }
        }
    }

    public static void equipmentMenu(GameEngine objGameEngine, Hero selectHero,
                                     int equipWeapon, int equipAccessories) {
        int heroAction = 99;

        while (heroAction != 0) {
            System.out.println("\n======================================");
            System.out.println("            Equipment Menu");
            System.out.println("======================================");
            System.out.println("[1] Equip weapon");
            System.out.println("[2] Unequip weapon");
            System.out.println("[3] Equip accessory");
            System.out.println("[4] Unequip accessory");
            System.out.println("[0] Main menu");
            System.out.println("======================================");
            System.out.print("Choose hero action: ");
            heroAction = sc.nextInt();

            Inventory tempInventory = objGameEngine.getObjInventory();
            int itemChoice;
            boolean itemAvailable;
            switch (heroAction) {
                case 0:
                    break;
                case 1:
                    if (equipWeapon == 0) {
                        // itemAvailable = tempInventory.printWeaponsInventory();
                        itemAvailable = tempInventory.printItemsInventory(tempInventory.getObjWeapons(),
                                ItemName.Weapon);

                        if (itemAvailable) {
                            System.out.print("Select weapon to equip: ");
                            itemChoice = sc.nextInt();

                            // hero mengenakan weapon
                            objGameEngine.getObjInventory().getObjWeapons().get(itemChoice - 1).equipped(selectHero);
                        } else {
                            System.out.println("\nHero can't be equip any weapon!");
                        }
                    } else {
                        System.out.println("\nHero can only equip one weapon!");
                    }
                    break;
                case 2:
                    if (equipWeapon == 1) {
                        tempInventory.printItemsInventory(tempInventory.getObjWeapons(), ItemName.Weapon);

                        System.out.print("Select weapon to unequip: ");
                        itemChoice = sc.nextInt();

                        // hero melepaskan weapon
                        objGameEngine.getObjInventory().getObjWeapons().get(itemChoice - 1).unequipped(selectHero);
                    } else {
                        System.out.println("\nHero hasn't equipped any weapon!");
                    }
                    break;
                case 3:
                    if (equipAccessories < 2) {
                        itemAvailable = tempInventory.printItemsInventory
                                (tempInventory.getObjAccessories(), ItemName.Accessory);

                        if (itemAvailable) {
                            System.out.print("Select accessory to equip: ");
                            itemChoice = sc.nextInt();

                            // hero mengenakan accessory
                            objGameEngine.getObjInventory().getObjWeapons().get(itemChoice - 1).equipped(selectHero);
                        } else {
                            System.out.println("\nHero can't be equip any accessory!");
                        }
                    } else {
                        System.out.println("\nHero can only equip maximum two accessories!");
                    }
                    break;
                case 4:
                    if (equipAccessories > 0) {
                        tempInventory.printItemsInventory(tempInventory.getObjAccessories(), ItemName.Accessory);

                        System.out.print("Select accessory to unequip: ");
                        itemChoice = sc.nextInt();

                        // hero mengenakan accessory
                        objGameEngine.getObjInventory().getObjWeapons().get(itemChoice - 1).unequipped(selectHero);
                    } else {
                        System.out.println("\nHero hasn't equipped any accessory!");
                    }
                    break;
                default:
                    System.out.println("Your input doesn't valid!");
                    break;
            }
        }
    }

    public static void mainMenu(GameEngine objGameEngine) {
        boolean isStopMenu = false;

        while (!isStopMenu) {
            System.out.println("\n======================================");
            System.out.println("               Main Menu");
            System.out.println("======================================");
            System.out.println("[1] Inventory");
            System.out.println("[2] Equipment");
            System.out.println("[3] Status");
            System.out.println("[4] Active Party");
            System.out.println("[5] Enemies Records");
            System.out.println("[6] Chapter Select");
            System.out.println("[7] Continue");
            System.out.println("[0] Exit Game");
            System.out.println("======================================");
            System.out.print("Choose menu : ");
            int mainMenuChoice = sc.nextInt();

            int selectHero;
            switch (mainMenuChoice) {
                case 0 -> {
                    System.out.println("\nYou are leaving the game....");
                    System.out.println("Thank you for playing the game!\n");
                    objGameEngine.setStop(true);
                    isStopMenu = true;
                }
                case 1 ->
                        // print inventory user
                        objGameEngine.getObjInventory().printInventory();
                case 2 -> {
                    printArrHero("noLegend", objGameEngine);
                    System.out.print("Select hero to open equipment: ");
                    selectHero = sc.nextInt();
                    System.out.println("\n======================================");
                    System.out.println("           Hero equipment");
                    System.out.println("======================================");

                    // jumlah weapon hero
                    int equipWeapon = objGameEngine.getObjInventory()
                            .printWeaponsInventory(objGameEngine.getUserHeroes().get((selectHero - 1)).getName());

                    // jumlah accessory hero
                    int equipAccessories = objGameEngine.getObjInventory()
                            .printAccessoriesInventory(objGameEngine.getUserHeroes().get((selectHero - 1)).getName());

                    // masuk ke menu equipment
                    equipmentMenu(objGameEngine, objGameEngine.getUserHeroes().get((selectHero - 1)), equipWeapon,
                            equipAccessories);
                }
                case 3 -> {
                    printArrHero("noLegend", objGameEngine);
                    System.out.print("Select hero to look at the status: ");
                    selectHero = sc.nextInt();

                    // print status hero
                    objGameEngine.getUserHeroes().get((selectHero - 1)).describe();
                }
                case 4 -> {
                    // Tampilkan activeHeroes
                    printArrHero(objGameEngine);

                    // Mau ganti active party?
                    System.out.print("Change active party? (Y/N): ");
                    String changeActiveHeroes = sc.next().toUpperCase();
                    switch (changeActiveHeroes) {
                        case "N":
                            break;
                        case "Y":
                            boolean done = false;

                            while (!done) {
                                // selama user tidak memilih untuk menyimpan perubahan active party
                                // edit active party
                                editActiveParty(objGameEngine);

                                System.out.print("End and save active party change? (Y/N): ");
                                String changeDone = sc.next().toUpperCase();

                                switch (changeDone) {
                                    case "N":
                                        break;
                                    case "Y":
                                        done = true;
                                        break;
                                    default:
                                        System.out.println("Your input doesn't valid!");
                                        break;
                                }
                            }
                            break;
                        default:
                            System.out.println("Your input doesn't valid!");
                            break;
                    }
                }
                case 5 -> System.out.println("Tampilkan data enemy yang sudah dikalahkan");
                case 6 -> System.out.println("Pilih Chapter");
                case 7 -> isStopMenu = true;
                default -> System.out.println("Your input doesn't valid!");
            }
        }
    }

    public static void adventureMenu(GameEngine objGameEngine) {
        System.out.println("\n======================================");
        System.out.print("\nNow you're in ");
        Hero.getActiveRoom().describe();

        System.out.println("\n======================================");
        System.out.println("              Hero Action");
        System.out.println("======================================");
        System.out.println("[1] Attack the enemy");
        System.out.println("[2] Open available box");
        System.out.println("[3] Move to the next room");
        System.out.println("[0] Main menu");
        System.out.println("======================================");
        System.out.print("Choose your hero action : ");
        int actionChoice = sc.nextInt();

        switch (actionChoice) {
            case 0:
                mainMenu(objGameEngine);
                break;
            case 1:
                // tampilan battleSystem
                // ambil active heroes untuk disimpan di dalam battleSystem
                // objGameEngine.getObjBattleSystem().setObjHeroes(objGameEngine.getActiveHeroes());

                // ambil objEnemies yang ada di dalam ruangan aktif hero
                // gunakan default method milik hero
                // objGameEngine.getObjBattleSystem().setObjEnemies(Hero.getActiveRoom().getObjEnemies());

                // mulai pertarungan
                // objGameEngine.getObjBattleSystem().startBattle();
                break;
            case 2:
                // tampilan box yang ada di ruangan
                if (Hero.getActiveRoom().getObjBoxes().isEmpty()) {
                    // jika array objBoxes yang ada di ruangan aktif hero kosong
                    System.out.println("\nThere's no box to be opened in this room");
                    break;
                }

                Hero.getActiveRoom().printBoxes();

                System.out.print("Choose the box number that you want to open : ");
                int boxChoice = sc.nextInt();

                if (boxChoice < 1 || boxChoice > Hero.getActiveRoom().getObjBoxes().size()) {
                    System.out.println("\nYour input doesn't valid!");
                } else {
                    Hero.getActiveRoom().getObjBoxes().get(boxChoice - 1).opened(objGameEngine.getObjInventory());
                    Hero.getActiveRoom().getObjBoxes().remove(boxChoice - 1);
                }
                break;
            case 3:
                // pilih arah untuk pergi ke ruangan selanjutnya
                System.out.print("\nChoose direction (W,A,S,D): ");
                String roomDirection = sc.next().toUpperCase();

                try {
                    // method valueOf akan memeriksa apakah terdapat nilai dari String roomDirection
                    Direction direction = Direction.valueOf(roomDirection);
                    Hero.moveToNextRoom(direction);
                } catch (IllegalArgumentException e) { // jika roomDirection bukan (W,A,S,D)
                    System.out.println("Your input doesn't valid!");
                }
                break;
            default:
                System.out.println("Your input doesn't valid!");
                break;
        }
    }

}
